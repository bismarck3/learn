/**
 * @projectName springbootTest
 * @package springboot.basic.thread
 * @className springboot.basic.thread.ThreadLocalTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.thread;

/**
 * ThreadLocalTest
 *
 * @description 本地线程测试
 * @author wangjing
 * @date 2019/8/15 16:32
 * @version v1.0.0
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        FlagCheckThreadLocalRunnable flagCheck = new FlagCheckThreadLocalRunnable();
        Thread thread = new Thread(flagCheck);
        Thread thread2 = new Thread(flagCheck);
        Thread thread3 = new Thread(flagCheck);
        Thread thread4 = new Thread(flagCheck);
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}


class FlagCheckRunnable implements Runnable{

    private boolean flag = true;

    public FlagCheckRunnable() {
    }

    public FlagCheckRunnable(boolean flag) {
        this.flag = flag;
    }

    @Override public void run() {
        for(int i = 0 ; i < 5; i++){
            if(flag){
                System.out.println(Thread.currentThread().getName()+"——flag为true,执行逻辑");
                flag = false;
            }else{
                System.out.println(Thread.currentThread().getName()+"——flag为false,执行逻辑");
                flag = true;
            }
        }
    }
}

class FlagCheckThreadLocalRunnable implements Runnable{

    private ThreadLocal<Boolean> flag = new ThreadLocal<Boolean>(){
        @Override protected Boolean initialValue() {
            return true;
        }
    };

    /**
     * @return the flag
     */
    public ThreadLocal<Boolean> getFlag() {
        return flag;
    }

    @Override public void run() {
        for(int i = 0 ; i < 5; i++){
            if(flag.get()){
                System.out.println(Thread.currentThread().getName()+"——flag为true,执行逻辑");
                flag.set(false);
            }else{
                System.out.println(Thread.currentThread().getName()+"——flag为false,执行逻辑");
                flag.set(true);
            }
        }
    }
}