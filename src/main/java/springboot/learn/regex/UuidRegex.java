package springboot.learn.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UuidRegex {

    private final static String UUID_REGEX = "[0-9A-Z]{32}";
    private final static String UUID_TEST = "xsadasd是的骄傲ID囧按实际的6FA01CB55031BF3BF5C1DB77116EC84A打死的是6FA01CB55031BF3BF5C1DB77116EC84B--6FA01CB55031BF3BF5C1DB77116EC8AS";
    
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(UUID_REGEX);
        Matcher matcher = pattern.matcher(UUID_TEST);
        if(matcher.find(UUID_TEST.length()-80)) {
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group());
        }
    }
}
