/**
 * @projectName learn
 * @package springboot.learn.agent
 * @className springboot.learn.agent.Main
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.agent;

import java.lang.instrument.Instrumentation;

/**
 * Main
 *
 * @description agent测试
 * @author wangjing
 * @date 2020/9/8 18:21
 * @version v1.0.0
 */
public class GreetingAgent {

    public static void premain(String options, Instrumentation instrumentation){
        if(options != null){
            System.out.println("called options\t" + options);
        }
        else {
            System.out.println("called no options");
        }
        instrumentation.addTransformer(new GreetingTransformer());
    }

}




