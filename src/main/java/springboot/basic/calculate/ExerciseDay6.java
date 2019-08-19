/**
 * @projectName springbootTest
 * @package springboot.basic.calculate
 * @className springboot.basic.calculate.ExerciseDay66
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.calculate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ExerciseDay66
 *
 * @description 练习6
 * @author wangjing
 * @date 2019/8/12 13:45
 * @version 
 */
public class ExerciseDay6 {

    private static final String FILE_READ = "C:\\Users\\lenovo\\Desktop\\技术交流\\电子科技大学实习\\java课程.md";

    private static final String READED_FILE_INFO = "C:\\Users\\lenovo\\Desktop\\技术交流\\电子科技大学实习\\读取文件信息.txt";

    static void filCommonOperation(){
        File file=new File("D:","HelloWorld.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("创建文件成功！");
            }else {
                System.out.println("创建文件失败！文件已经存在");
            }
        } catch (IOException e) {
            System.out.println("创建文件失败！");
        }
        if (file.isFile()) {
            System.out.println("这是一个文件");
        } else {
            System.out.println("这是一个目录");
        }
        File file2=new File("D:/IOTest");
        file2.mkdirs();
        if (file.renameTo(new File(file2.getPath()+File.separator+file.getName()))) {
            System.out.println("文件移动成功！");
        } else {
            System.out.println("文件移动失败");
        }
        String[] arr=file2.list();
        for (String string : arr) {
            System.out.println(string);
        }
    }

    static List<File> testListFiles(String filePath){
        List<File> files=new ArrayList<>();
        File file=new File(filePath);
        if (file.exists()&&file.isDirectory()) {
            getChildFile(file,files);
        }
        return files;
    }

    private static void getChildFile(File file, List<File> files) {
        File[] fillArr=file.listFiles();
        if (fillArr==null) {
            return;
        }
        for (File file2 : fillArr) {
            files.add(file2);
            getChildFile(file2, files);
        }
    }

    static void getAllJavaInThisWorkSpace(){
        List<File>list=testListFiles(".");
        for (File file : list) {
            if (file.toString().endsWith(".java")) {
                System.out.println(file.getName());
            }
        }

    }

    static String testReadDiskFile(String filePath){
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file)){
            int len;
            byte[] buf = new byte[1024];
            StringBuffer sb = new StringBuffer();
            while ((len = fis.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
            }
            System.out.println(sb);
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static void testWriteFile(){
        File file = new File("D:\\Hello.txt");
        try(FileOutputStream fos = new FileOutputStream(file)) {
            fos.write("HelloWorld你好世界".getBytes());
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void testCopyResource(){
        File fileFrom = new File("C:\\Users\\lenovo\\Desktop\\markdownPictrue\\一次request请求.png");
        File fileTo = new File("D:\\picture.jpg");

        try(FileInputStream fis = new FileInputStream(fileFrom);
            FileOutputStream fos = new FileOutputStream(fileTo)) {
            int len;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
            System.out.println("文件复制成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void testCountFromFile() throws FileNotFoundException {
        String readDiskFileTxt = testReadDiskFile(READED_FILE_INFO);
        ExerciseDay3.countYourLineWords(readDiskFileTxt);
    }

    public static void main(String[] args) throws FileNotFoundException {
        testCountFromFile();
    }
}
