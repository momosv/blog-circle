package cn.momosv.blog.circle.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration("circleDatasourceConfig")
@ConfigurationProperties(prefix = "spring.circle-datasource")
public class DatasourceConfig {
	private Logger logger = LoggerFactory.getLogger(DatasourceConfig.class);
	
   // @Value("${spring.circle-datasource.url}")
    private String url;
    
  //  @Value("${spring.circle-datasource.type}")
    private String type;
    
  //  @Value("${spring.circle-datasource.username}")
    private String username;

  //  @Value("${spring.circle-datasource.name}")
    private String name;
    
   // @Value("${spring.circle-datasource.password}")
    private String password;
    
   // @Value("${spring.circle-datasource.driver-class-name}")
    private String driverClassName;
    
  //  @Value("${spring.circle-datasource.initialSize}")
    private int initialSize;
    
    //@Value("${spring.circle-datasource.minIdle}")
    private int minIdle;
    
   // @Value("${spring.circle-datasource.maxActive}")
    private int maxActive;
    
  //  @Value("${spring.circle-datasource.maxWait}")
    private int maxWait;
    
    //@Value("${spring.circle-datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    
   // @Value("${spring.circle-datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

   // @Value("${spring.circle-datasource.validationQuery}")
    private String validationQuery;
    
 //   @Value("${spring.circle-datasource.testWhileIdle}")
    private boolean testWhileIdle;
    
   // @Value("${spring.circle-datasource.testOnBorrow}")
    private boolean testOnBorrow;
    
   // @Value("${spring.circle-datasource.testOnReturn}")
    private boolean testOnReturn;
    
   // @Value("${spring.circle-datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

  //  @Value("${spring.datasource.filters}")
    private String filters;

    
	
    @Bean(name="circleDataSource")
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();  
        try {  
	        datasource.setUrl(this.url);
	        datasource.setDbType(type);
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


    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public int getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public int getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public boolean isPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public void setPoolPreparedStatements(boolean poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }
}

