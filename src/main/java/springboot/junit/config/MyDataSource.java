package springboot.junit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 
 * MyDataSource
 * 
 * @description SpringBoot获取数据源-1
 * @author wangj
 * @date 2018年7月3日 下午2:31:26
 * @version
 */
// @Configuration
public class MyDataSource {

    @Autowired
    private DruidDataSourceConfig dataSourceConfig;

    @Bean
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(dataSourceConfig.getUrl());
        ds.setUsername(dataSourceConfig.getUsername());
        ds.setPassword(dataSourceConfig.getPassword());
        ds.setDriverClassName(dataSourceConfig.getDriverClassName());
        return ds;
    }
}
