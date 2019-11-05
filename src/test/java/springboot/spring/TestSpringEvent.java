/**
 * @projectName springbootTest
 * @package springboot.spring
 * @className springboot.spring.TestSpringEvent
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.MyApplication;

/**
 * TestSpringEvent
 *
 * @description 
 * @author wangjing
 * @date 2019/10/11 11:34
 * @version v1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class TestSpringEvent {

    @Test
    public void testPublishEvent(){
        SpringContextHolder.publishEvent(new LogEvent("213123213"));
    }
}
