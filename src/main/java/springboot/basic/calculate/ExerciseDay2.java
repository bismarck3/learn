/**
 * @projectName springbootTest
 * @package springboot.basic.calculate
 * @className springboot.basic.calculate.ExerciseDay2
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.calculate;

import springboot.basic.PrintUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ExerciseDay2
 *
 * @description 字符串校验
 * @author wangjing
 * @date 2019/8/2 17:56
 * @version v1.0.0
 */
public class ExerciseDay2 {

    static void checkCharAndToUp(char character){
        if(character>='a' && character<='z'){
            PrintUtil.println("该字母是小写,原字母为："+character);
            char toUpChar = (char)(character-('a'-'A'));
            PrintUtil.println("转换为大写之后为："+toUpChar);
        }else{
            PrintUtil.println("该字母不是小写字母");
        }
    }

    static void printStars(int[] stars){
        for(int starNumber : stars){
            String needToPrintItem = "*";
            for(int i = 1; i < starNumber; i++){
                needToPrintItem+="*";
            }
            PrintUtil.println(needToPrintItem);
        }
    }

    static List<Integer> decomposePrimeFactor(int number){
        List<Integer> primeFactors = new ArrayList<>();
        for(int i = 2; i < number; i++){
            while(number%i==0){
                number/=i;
                primeFactors.add(i);
            }
        }
        primeFactors.add(number);
        return primeFactors;
    }

    static void yangHuiTriangle(int height){
        int[][] numbers = new int[height][];
        // 二维数组的length标识numbers的行数
        for(int i = 0 ; i < numbers.length; i++){
            for(int k = numbers.length-1-i; k>0; k--){
                System.out.print("  ");
            }
            numbers[i] = new int[i+1];
            for(int j = 0; j < numbers[i].length; j++){
                if(j == 0 || j == numbers[i].length -1){
                    numbers[i][j] = 1 ;
                }else{
                    numbers[i][j] = numbers[i-1][j-1]+numbers[i-1][j];
                }
                System.out.printf("%4d", numbers[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        yangHuiTriangle(5);
    }
}
