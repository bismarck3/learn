/**
 * @projectName springbootTest
 * @package springboot.basic.calculate
 * @className springboot.basic.calculate.ExerciseDay3
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.calculate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ExerciseDay3
 *
 * @description 字符计数
 * @author wangjing
 * @date 2019/8/2 11:10
 * @version v1.0.0
 */
class CountNumber{

    private int countChinese = 0;
    private int countLetter = 0;
    private int countNumber = 0;
    private int countSpace = 0;
    private int countOther = 0;

    public int getCountChinese() {
        return countChinese;
    }

    public void setCountChinese(int countChinese) {
        this.countChinese = countChinese;
    }

    public int getCountLetter() {
        return countLetter;
    }

    public void setCountLetter(int countLetter) {
        this.countLetter = countLetter;
    }

    public int getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(int countNumber) {
        this.countNumber = countNumber;
    }

    public int getCountSpace() {
        return countSpace;
    }

    public void setCountSpace(int countSpace) {
        this.countSpace = countSpace;
    }

    public int getCountOther() {
        return countOther;
    }

    public void setCountOther(int countOther) {
        this.countOther = countOther;
    }
}

public class ExerciseDay3 {

    private static Map<String, Integer> expressCountMap = new HashMap<>();
    // 1 3|4|5|7|8|9 9位数字
    // [1][3456789]\d{9}
    // （2018）民事一审第10号
    // [(][12][09]\d{2}[\u4e00-\u9fa5]
    private static String E1 = "[\u4e00-\u9fa5]";
    private static String E2 = "[a-zA-Z]";
    private static String E3 = "[0-9]";
    private static String E4 = "\\s";


    public static void countYourLineWords(String str) {
        CountNumber countNumber = new CountNumber();
        char[] arrayChar = str.toCharArray();
        String[] arrayString = new String[arrayChar.length];
        for (int i = 0; i < arrayChar.length; i++){
            arrayString[i] = String.valueOf(arrayChar[i]);
        }

        for (String s : arrayString) {
            matchExpression(s, countNumber);
        }
        System.out.println("输入的汉字个数：" + countNumber.getCountChinese());
        System.out.println("输入的字母个数：" + countNumber.getCountLetter());
        System.out.println("输入的数字个数：" + countNumber.getCountNumber());
        System.out.println("输入的空格个数：" + countNumber.getCountSpace());
        System.out.println("输入的其它字符个数：" + countNumber.getCountOther());
    }

    private static int matchExpression(String s, CountNumber countNumber){
        if (s.matches(E1)){
            countNumber.setCountChinese(countNumber.getCountChinese()+1);
        }
        else if (s.matches(E2)){
            countNumber.setCountLetter(countNumber.getCountLetter()+1);
        }
        else if (s.matches(E3)){
            countNumber.setCountNumber(countNumber.getCountNumber()+1);
        }
        else if (s.matches(E4)){
            countNumber.setCountSpace(countNumber.getCountSpace()+1);
        }
        else{
            countNumber.setCountOther(countNumber.getCountOther()+1);
        }
        return 0;
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
