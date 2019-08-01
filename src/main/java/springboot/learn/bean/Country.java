/**
 * @projectName springbootTest
 * @package springboot.bean
 * @className springboot.bean.Country
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.bean;

/**
 * Country
 * @description user->address->country
 * @author wangj
 * @date 2018年9月4日 下午12:40:09
 * @version 
 */
public class Country {

    /** iso代码 **/
    private IsoCode isoCode;

    public IsoCode getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(IsoCode isoCode) {
        this.isoCode = isoCode;
    }

    public Country(IsoCode isoCode) {
        super();
        this.isoCode = isoCode;
    }
    
    
}
