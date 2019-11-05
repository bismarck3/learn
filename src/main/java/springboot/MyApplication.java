package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * MyApplication
 * 
 * @description springBoot
 * @author wangj
 * @date 2018年4月27日 下午7:28:07
 * @version
 */
@EnableCaching
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableJpaRepositories
@EnableAspectJAutoProxy
public class MyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}



}
