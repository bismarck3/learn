/**
 * @projectName learn
 * @package springboot.learn.serializable
 * @className springboot.learn.serializable.Person
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Person
 *
 * @description external序列化对象
 * @author wangjing
 * @date 2020/11/16 15:08
 * @version v1.0.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Externalizable {

    private static final long serialVersionUID = 1L;

    private String userName;

    private String password;

    private Integer age;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        LocalDate now = LocalDate.now();
        out.writeObject(userName);
        out.writeObject(password);
        out.writeObject(password);
        out.writeObject(now);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.userName = (String)in.readObject();
        this.password = (String)in.readObject();
        this.age = (Integer)in.readObject();
        LocalDate dateTime = (LocalDate)in.readObject();
        System.out.println(dateTime);
    }

    @Override
    public String toString() {
        return "Person{" + "userName='" + userName + '\'' + ", password='" + password + '\'' + ", age=" + age + '}';
    }
}
