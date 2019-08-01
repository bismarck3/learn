/**
 * @projectName springbootTest
 * @package springboot.bean
 * @className springboot.bean.Address
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.bean;

/**
 * Address
 * @description user->address
 * @author wangj
 * @date 2018年9月4日 下午12:39:48
 * @version 
 */
public class Address {

    /** 国家 **/
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Address(Country country) {
        super();
        this.country = country;
    }
    
    
}
