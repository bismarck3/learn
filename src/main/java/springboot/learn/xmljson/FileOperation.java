package springboot.learn.xmljson;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileOperation {

	private static Logger logger = LoggerFactory.getLogger(FileOperation.class);

	/**
	 * 读取JSON文件
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static String readTxtFile(String fileName) {
		String encoding = "UTF-8";
		File file = new File(fileName);
		try{
			String text=FileUtils.readFileToString(file, encoding);
			return text;
		} catch (Exception e) {
			logger.error("读取文件出错", e);
			return null;
		}
	}
}
