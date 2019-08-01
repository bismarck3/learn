package springboot.learn.converter;

import org.apache.commons.beanutils.converters.ArrayConverter;
import org.apache.commons.beanutils.converters.StringConverter;

public class ApacheConverter {

    public static void main(String[] args) {
        String list = "{1,2,3,42,3,43,123,321,34,41,134}";
        ArrayConverter arrayConverter = new ArrayConverter(String[].class, new StringConverter());
        String [] s = arrayConverter.convert(String[].class, list);
        for (String string : s) {
            System.out.println(string);
        }
    }
}
