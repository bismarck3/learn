package springboot.learn.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TimeRegex {

	public static void main(String[] args) {
	    String time = "23:00";
	    Pattern p = Pattern.compile("^([01][0-9]|2[0-3]):([0-5][0-9])$");
	    Matcher m = p.matcher(time);
	    if(m.find()){
	        System.out.println(m.group());
	    }
	}

}
