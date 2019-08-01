package springboot.learn.extend;

import java.io.InputStream;

public class Child implements Parent{

    @Override
    public InputStream testExtend(InputStream inputStream) throws Exception {
        return null;
    }

}
