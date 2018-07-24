package cn.momosv.blog.circle.datasource;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration("circleDatasourceConfig")
@ConfigurationProperties(prefix = "spring.circle-datasource")
public class DatasourceConfig {
	private Logger logger = LoggerFactory.getLogger(DatasourceConfig.class);

    @Bean(name="circleDataSource")
    @ConfigurationProperties(prefix = "spring.circle-datasource")
    public DataSource dataSource(){
        DruidDataSource datasource = DruidDataSourceBuilder.create().build();
        try {  
/*	        datasource.setUrl(this.url);
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
            datasource.setFilters(filters);*/
            //datasource.setRemoveAbandoned(true);
         //   datasource.setUseGlobalDataSourceStat(true);
        } catch (Exception e) {
            logger.error("druid configuration initialization filter", e);  
        }  
        return datasource;  
    }

}

