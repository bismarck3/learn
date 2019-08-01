package springboot.junit.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleTest {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[\\(|\\（]\\S[\\)|\\）]$");
//        Matcher matcher = pattern.matcher("(民初),（刑初),(民初）,（民初)");
        Matcher matcher = pattern.matcher("(民初)");
        while(matcher.find()){
            matcher.group();
        }
    }
}
