/**
 * @projectName springbootTest
 * @package springboot.learn.strategy
 * @className springboot.learn.strategy.Criteria
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.example;

import springboot.learn.bean.Person;

/**
 * Criteria
 * @description 策略接口
 * @author wangj
 * @date 2018年9月4日 
 * @version 
 */
public interface Strategy {

    /** 匹配策略 **/
    boolean matches(Person person);
}
