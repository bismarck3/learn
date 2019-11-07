/**
 * @projectName springbootTest
 * @package springboot.spring
 * @className springboot.spring.LogListener
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.spring;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * LogListener
 *
 * @description 日志事件监听器
 * @author wangjing
 * @date 2019/10/11 11:30
 * @version v1.0.0
 */
@Component
public class LogListener {

    @EventListener(LogEvent.class)
    public void saveLog(LogEvent logEvent){
        System.out.println("保存日志:"+logEvent.getSource());
    }
}
