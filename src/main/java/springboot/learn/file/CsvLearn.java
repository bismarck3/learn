package springboot.learn.file;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;



public class CsvLearn {

    private static Logger logger = LoggerFactory.getLogger(CsvLearn.class);
    
    public static void main(String[] args) {
        File file = new File("C:\\Users\\wangj\\Desktop\\r.csv");
        try {
            List<String> fileList = FileUtils.readLines(file, "utf-8");
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            Iterator<String>  lineIterator= fileList.iterator();
            while(lineIterator.hasNext()){
                String data = lineIterator.next();
                String [] datas = data.split(",");
                map.put(datas[0].trim(), datas[1].trim());
            }
            System.out.println(JSON.toJSONString(map));
            
        } catch (IOException e) {
            logger.error("Bug in CsvLearn",e);
        }
    }
}
