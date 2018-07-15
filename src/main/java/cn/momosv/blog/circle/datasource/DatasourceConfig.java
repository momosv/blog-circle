package cn.momosv.blog.circle.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration("circleDatasourceConfig")
public class DatasourceConfig {
	private Logger logger = LoggerFactory.getLogger(DatasourceConfig.class);
	
    @Value("${spring.circle-datasource.url}")
    private String dbUrl;
    
    @Value("${spring.circle-datasource.type}")
    private String dbType;
    
    @Value("${spring.circle-datasource.username}")
    private String username;

    @Value("${spring.circle-datasource.name}")
    private String name;
    
    @Value("${spring.circle-datasource.password}")
    private String password;
    
    @Value("${spring.circle-datasource.driver-class-name}")
    private String driverClassName;
    
    @Value("${spring.circle-datasource.initialSize}")
    private int initialSize;
    
    @Value("${spring.circle-datasource.minIdle}")
    private int minIdle;
    
    @Value("${spring.circle-datasource.maxActive}")
    private int maxActive;
    
    @Value("${spring.circle-datasource.maxWait}")
    private int maxWait;
    
    @Value("${spring.circle-datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    
    @Value("${spring.circle-datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    
    @Value("${spring.circle-datasource.validationQuery}")
    private String validationQuery;
    
    @Value("${spring.circle-datasource.testWhileIdle}")
    private boolean testWhileIdle;
    
    @Value("${spring.circle-datasource.testOnBorrow}")
    private boolean testOnBorrow;
    
    @Value("${spring.circle-datasource.testOnReturn}")
    private boolean testOnReturn;
    
    @Value("${spring.circle-datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.filters}")
    private String filters;

    
	
    @Bean(name="circleDataSource")
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();  
        try {  
	        datasource.setUrl(this.dbUrl);  
	        datasource.setDbType(dbType);
	        datasource.setUsername(username);  
	        datasource.setPassword(password);  
	        datasource.setDriverClassName(driverClassName);  
	        datasource.setInitialSize(initialSize);  
	        datasource.setMinIdle(minIdle);  
	        datasource.setMaxActive(maxActive);  
	        datasource.setMaxWait(maxWait);  
	        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);  
	        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);  
	        datasource.setValidationQuery(validationQuery);  
	        datasource.setTestWhileIdle(testWhileIdle);  
	        datasource.setTestOnBorrow(testOnBorrow);  
	        datasource.setTestOnReturn(testOnReturn);  
	        datasource.setPoolPreparedStatements(poolPreparedStatements);  
            datasource.setFilters(filters);  
        } catch (SQLException e) {  
            logger.error("druid configuration initialization filter", e);  
        }  
        return datasource;  
    }

}  

