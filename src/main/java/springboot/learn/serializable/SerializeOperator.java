/**
 * @projectName learn
 * @package springboot.learn.serializable
 * @className springboot.learn.serializable.SerializeOperator
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;


/**
 * SerializeOperator
 *
 * @description 序列化操作对象
 * @author wangjing
 * @date 2020/11/16 15:19
 * @version v1.0.0
 */
public class SerializeOperator {

    /**
     * 序列化方法
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void serializable(Object serializeObject) throws FileNotFoundException, IOException{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:\\a.txt"));
        outputStream.writeObject(serializeObject);
    }

    /**
     * 反序列化的方法
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public Object deSerializable() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\a.txt"));
        return ois.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializeArticle();
    }

    public static void serializeArticle() throws IOException, ClassNotFoundException {
        SerializeOperator serializeOperator = new SerializeOperator();
        Article article = new Article(1, "标题", "内容", "xxx", LocalDateTime.now(),
            "172.25.8.68", new User("WJ", 11));
        System.out.println("为序列化之前的相关数据如下:\n" + article.toString());
        serializeOperator.serializable(article);
        Article newArticle = (Article)serializeOperator.deSerializable();
        System.out.println("-------------------------------------------------------");
        System.out.println("序列化之后的相关数据如下:\n" + newArticle.toString());
    }

    private static void serializePerson() throws IOException, ClassNotFoundException {
        SerializeOperator operate = new SerializeOperator();
        Person person = new Person("小浩", "123456", 20);
        System.out.println("为序列化之前的相关数据如下:\n" + person.toString());
        operate.serializable(person);
        Person newPerson = (Person)operate.deSerializable();
        System.out.println("-------------------------------------------------------");
        System.out.println("序列化之后的相关数据如下:\n" + newPerson.toString());
    }
}
