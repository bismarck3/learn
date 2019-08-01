package springboot.learn.extend;

import java.io.InputStream;

public interface Parent {
    
   InputStream testExtend(InputStream inputStream) throws Exception;
}
