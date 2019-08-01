/**
 * @projectName springbootTest
 * @package springboot.learn
 * @className springboot.learn.UserSupplier
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.supplier;

import java.util.UUID;
import java.util.function.Supplier;

import springboot.learn.bean.Address;
import springboot.learn.bean.Country;
import springboot.learn.bean.IsoCode;
import springboot.learn.bean.School;
import springboot.learn.bean.User;

/**
 * UserSupplier
 * @description 用户supplier
 * @author wangj
 * @date 2018年9月4日 下午12:44:29
 * @version 
 */
public class UserSupplier {

    /**
     * 
     * UserSupplier
     * @description 默认的user supplier
     * @return
     * @author wangj
     * @date 2018年9月4日 下午12:50:30
     * @version 
     */
    public static Supplier<User> getDefaultUser(){
        Supplier<User> supplier = () -> {
            User user = new User();
            user.setName("wangj");
            user.setAge(22);
            user.setId(UUID.randomUUID().toString());
            School school = new School();
            school.setCode("10614");
            school.setName("UESTC");           
            user.setSchool(school);
            user.setAddress(new Address(new Country(new IsoCode("CN","156"))));
            return user;
        };
        return supplier;
    }
}
