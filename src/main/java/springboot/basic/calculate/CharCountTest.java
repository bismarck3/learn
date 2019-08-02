/**
 * @projectName springbootTest
 * @package springboot.basic.calculate
 * @className springboot.basic.calculate.CharCountTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.calculate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CharCountTest
 *
 * @description 字符计数
 * @author wangjing
 * @date 2019/8/2 11:10
 * @version v1.0.0
 */
public class CharCountTest {

    private static Map<String, Integer> expressCountMap = new HashMap<>();

    private static String E1 = "[\u4e00-\u9fa5]";
    private static String E2 = "[a-zA-Z]";
    private static String E3 = "[0-9]";
    private static String E4 = "\\s";


    public static void countYourLineWords(String str) {
        int countChinese = 0;
        int countLetter = 0;
        int countNumber = 0;
        int countSpace = 0;
        int countOther = 0;
        char[] arrayChar = str.toCharArray();
        String[] arrayString = new String[arrayChar.length];
        for (int i = 0; i < arrayChar.length; i++){
            arrayString[i] = String.valueOf(arrayChar[i]);
        }

        for (String s : arrayString) {
            if (s.matches(E1)){
                countChinese++;
            }
            else if (s.matches(E2)){
                countLetter++;
            }
            else if (s.matches(E3)){
                countNumber++;
            }
            else if (s.matches(E4)){
                countSpace++;
            }
            else{
                countOther++;
            }
        }
        System.out.println("输入的汉字个数：" + countChinese);
        System.out.println("输入的字母个数：" + countLetter);
        System.out.println("输入的数字个数：" + countNumber);
        System.out.println("输入的空格个数：" + countSpace);
        System.out.println("输入的其它字符个数：" + countOther);
    }

    public static void countYourLineWordsTable(String str) {
        int countChinese = 0;
        int countLetter = 0;
        int countNumber = 0;
        int countSpace = 0;
        int countOther = 0;
        expressCountMap.put(E1,countChinese);
        expressCountMap.put(E2,countLetter);
        expressCountMap.put(E3,countNumber);
        expressCountMap.put(E4,countSpace);
        expressCountMap.put("",countOther);
        char[] arrayChar = str.toCharArray();
        String[] arrayString = new String[arrayChar.length];
        for (int i = 0; i < arrayChar.length; i++){
            arrayString[i] = String.valueOf(arrayChar[i]);
        }
        List<String> expresses = Arrays.asList(E1, E2, E3, E4);
        for (String s : arrayString) {
            for(int i = 0 ; i < expresses.size() ; i ++){
                if(s.matches(expresses.get(i))){
                    Integer tempCount = expressCountMap.get(expresses.get(i));
                    tempCount++;
                    expressCountMap.put(expresses.get(i), tempCount);
                    break;
                }
            }
        }
        System.out.println("输入的汉字个数：" + expressCountMap.get(E1));
        System.out.println("输入的字母个数：" + expressCountMap.get(E2));
        System.out.println("输入的数字个数：" + expressCountMap.get(E3));
        System.out.println("输入的空格个数：" + expressCountMap.get(E4));
        System.out.println("输入的其它字符个数：" + expressCountMap.get(""));
    }

    public static void main(String[] args) {
        countYourLineWords("  的 ");
    }
}
