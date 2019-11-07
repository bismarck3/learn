/**
 * @projectName springbootTest
 * @package springboot.spring
 * @className springboot.spring.LogEvent
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.spring;

import org.springframework.context.ApplicationEvent;

/**
 * LogEvent
 *
 * @description 日志事件
 * @author wangjing
 * @date 2019/10/11 11:29
 * @version v1.0.0
 */
public class LogEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public LogEvent(Object source) {
        super(source);
    }
}
