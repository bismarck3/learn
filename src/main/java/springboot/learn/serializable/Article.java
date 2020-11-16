/**
 * @projectName learn
 * @package springboot.learn.serializable
 * @className springboot.learn.serializable.Article
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.serializable;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Article
 *
 * @description 序列化对象
 * @author wangjing
 * @date 2020/11/16 15:06
 * @version v1.0.0
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Article implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String content;

    private String faceIcon;

    private LocalDateTime postTime;

    private String ipAddr;

    private User author;



}
