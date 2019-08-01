package springboot.learn.extend;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AbstractParent {

    InputStream testExtend(ByteArrayInputStream inputStream) throws Exception {
        System.out.println("ByteArrayInputStream");
        return null;
    }
}
