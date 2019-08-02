/**
 * @projectName springbootTest
 * @package springboot.basic.calculate
 * @className springboot.basic.calculate.Exercise
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.calculate;

import java.util.HashMap;
import java.util.Map;

/**
 * Exercise
 *
 * @description 练习
 * @author wangjing
 * @date 2019/8/2 10:15
 * @version v1.0.0
 */
public class Exercise {

    private static final String[] weeks = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};

    private static int[] point = new int[]{59,79,89,100};
    private static char[] rank = new char[]{'D', 'C', 'B', 'A'};

    private static final Map<String, String> weekDoingMap = new HashMap<>();
    static{
        weekDoingMap.put("星期一", "上班");
        weekDoingMap.put("星期二", "开会");
        weekDoingMap.put("星期三", "学习");
        weekDoingMap.put("星期四", "运动");
        weekDoingMap.put("星期五", "睡觉");
        weekDoingMap.put("星期六", "出游");
        weekDoingMap.put("星期日", "玩游戏");
    }


    static String getYourWeek(int weekNumber){
        return weeks[weekNumber-1];
    }

    static char getYourRankByYourSore(int sore){
        char yourRank= 'D';
        for(int i = 0 ; i <point.length ; i ++){
            if(sore <= point[i]){
                yourRank = rank[i];
                break;
            }
        }
        return yourRank;
    }

    static char getYourRankByYourSoreUseIfElse(int sore){
        char yourRank = 'D';
        if(sore <= 59){
            yourRank = 'D';
        }else if(sore <= 79){
            yourRank = 'C';
        }else if(sore <= 89){
            yourRank = 'B';
        }else{
            yourRank = 'A';
        }
        return yourRank;
    }

    static int fibonacci(int sequence){
        if(sequence == 1 || sequence == 2){
            return 1;
        }else{
            return fibonacci(sequence-1)+fibonacci(sequence-2);
        }
    }

    static void print(Object obj){
        System.out.println(obj);
    }

    static String getWhatYouNeedToDo(int weekNumber){
        return weekDoingMap.get(getYourWeek(weekNumber));
    }

    public static void main(String[] args) {
        print(getWhatYouNeedToDo(1));
    }
}
