/**
 * @projectName springbootTest
 * @package springboot.learn.enums
 * @className springboot.learn.enums.Caculator
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.enums;
/**
 * Caculator
 *
 * @description 策略枚举
 * @author wangjing
 * @date 2019/9/21 12:01
 * @version v1.0.0
 */
public enum  Calculator {

    ADD("+"){
        @Override
        public int execute(int a, int b) {
            return a + b;
        }
    },

    SUB("-"){
        @Override
        public int execute(int a, int b) {
            return a + b;
        }
    };

    private String value;


    private Calculator(String value){
        this.value = value;
    }

    public abstract int execute(int a, int b);
}
