/**
 * @projectName springbootTest
 * @package springboot.basic.calculate.sync
 * @className springboot.basic.calculate.sync.ThreadRunCountSynchro
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.calculate.sync;
/**
 * ThreadRunCountSynchro
 *
 * @description 
 * @author wangjing
 * @date 2019/8/19 18:05
 * @version 
 */
public class ThreadRunCountSynchro implements ThreadRunCount{

    private boolean flag = false;

    @Override public synchronized void mainFunction(){
        while(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<5;i++){
            System.out.println("主程序执行"+(i+1)+"次");
        }
        this.notify();
        flag = false;
    }

    @Override public synchronized void subFunction(){
        while(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<3;i++){
            System.out.println("子程序执行"+(i+1)+"次");
        }
        this.notify();
        flag = true;
    }
}
