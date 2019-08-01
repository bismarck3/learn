/**
 * @projectName springbootTest
 * @package springboot.bean
 * @className springboot.bean.IsoCode
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.bean;

/**
 * IsoCode
 * @description User->Address->Country-IsoCode
 * @author wangj
 * @date 2018年9月4日 下午12:40:26
 * @version 
 */
public class IsoCode {

    /** 代码 **/
    private String code;
    
    /** 描述 **/
    private String introduction;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public IsoCode(String code, String introduction) {
        super();
        this.code = code;
        this.introduction = introduction;
    }

    public IsoCode() {
        super();
    }
    
}
