/**
 * @projectName learn
 * @package springboot.learn.serializable
 * @className springboot.learn.serializable.User
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.serializable;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User
 *
 * @description 
 * @author wangjing
 * @date 2020/11/16 15:07
 * @version v1.0.0
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User implements Serializable {

    private String name;

    private Integer age;
}
