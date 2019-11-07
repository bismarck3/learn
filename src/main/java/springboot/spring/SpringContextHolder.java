/**
 * @projectName springbootTest
 * @package springboot.spring
 * @className springboot.spring.SpringContextHolder
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * SpringContextHolder
 *
 * @description spring上下文容器
 * @author wangjing
 * @date 2019/10/11 11:31
 * @version v1.0.0
 */
@Component
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

    private static ApplicationContext applicationContext = null;

    @Override
    public void destroy() {
        applicationContext = null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static void publishEvent(ApplicationEvent applicationEvent){
        if(applicationContext == null){
            return;
        }
        applicationContext.publishEvent(applicationEvent);
    }
}
