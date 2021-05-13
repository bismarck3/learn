/**
 * @projectName learn
 * @package springboot.middle.redis
 * @className springboot.middle.redis.Lock
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.middle.redis;

import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

import lombok.SneakyThrows;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Lock
 *
 * @description redis锁
 * @author wangjing
 * @date 2021/4/20 10:39
 * @version v1.0.0
 */
public class RedisLock {

    private static int num = 200000;

    private final String LOCK_VALUE = "lock";

    public boolean lock(Jedis jedis, String key) {
        return this.tryLock(jedis, key, LOCK_VALUE, 60);
    }

    public boolean unlock(Jedis jedis, String key) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] "
            + "then return redis.call('del', KEYS[1]) "
            + "else return 0 "
            + "end";
        Object eval = jedis.eval(script, Collections.singletonList(key), Collections.singletonList(LOCK_VALUE));
        return Objects.equals(eval, "OK");
    }

    private boolean tryLock(Jedis jedis, String key, String value, long expireMillis) {
        String result = jedis.set(key, value, "NX", "EX", expireMillis);
        if ("OK".equalsIgnoreCase(result)) {
            return true;
        }
        return false;
    }

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println(num);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(32);
        jedisPoolConfig.setMaxTotal(999);
        jedisPoolConfig.setMaxWaitMillis(10 * 1000);
        jedisPoolConfig.setTestOnBorrow(true);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"172.25.17.131", 6379, 10000);
        RedisLock redisLock = new RedisLock();
        for (int i = 10; i > 0; i--) {
            new Thread(new MyRunnable(redisLock, jedisPool.getResource(), countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.println(num);
        System.exit(1);
    }
    static class MyRunnable implements Runnable {

        private RedisLock redisLock;

        private Jedis jedis;

        private CountDownLatch countDownLatch;

        public MyRunnable(RedisLock redisLock, Jedis jedis, CountDownLatch countDownLatch) {
            this.redisLock = redisLock;
            this.jedis = jedis;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            redisLock.lock(jedis,"test");
            for (int i = 0; i < 20000; i++) {
                num--;
            }
            System.out.println(Thread.currentThread().getName() + "：" + num);
            countDownLatch.countDown();
            redisLock.unlock(jedis,"test");
        }
    }

}
