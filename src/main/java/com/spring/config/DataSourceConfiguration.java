package com.spring.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * 数据源的配置
 * @author xwf
 *
 */

@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfiguration {
	@Value("${jdbc.driver-class-name}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.max-idle}")
    private int maxIdel;
    @Value("${jdbc.min-idle}")
    private int minIdle;
    @Value("${jdbc.max-wait-millis}")
    private long maxWait;
    @Value("${jdbc.initial-size}")
    private int initialSize;
    @Value("${jdbc.max-active}")
    private int maxActive;
    
    @Value("${jdbc.validation-query}")
    private String validationQuery;
    
    @Value("${jdbc.test-on-borrow}")
    private boolean testOnBorrow;
    @Value("${jdbc.test-while-idle}")
    private boolean testWhileIdle;
    
    @Value("${jdbc.time-between-eviction-runs-millis}")
    private long timeBetweenEvictionRunsMillis;
    
    /**
     * 此处设置数据源的信息与连接池的操作
     * @return
     */
    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxIdle(maxIdel);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        
        return dataSource;
    }
}
