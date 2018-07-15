package cn.momosv.blog.circle.mybatisConfig;


import cn.momosv.blog.common.config.SqlPrintInterceptor;
import com.github.pagehelper.PageHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * mybatis的相关配置设置
 * @author Jfei
 *
 */

@MapperScan(value = "cn.momosv.blog.circle.dao",sqlSessionFactoryRef = "circleSqlSessionFactory")
@Configuration
@ConfigurationProperties
@EnableTransactionManagement
public class CircleMybatisConfiguration {

	private static Log logger = LogFactory.getLog(CircleMybatisConfiguration.class);


    //  配置类型别名
    @Value("${mybatis2.type-aliases-package}")
    private String typeAliasesPackage2;

    //  配置mapper的扫描，找到所有的mapper.xml映射文件
    @Value("${mybatis2.ws-mapper-locations}")
    private String mapperLocations2;

    //  配置mapper的扫描，找到所有的mapper.xml映射文件
    @Value("${mybatis.ws-mapper-locations}")
    private String mapperLocations;

    //  加载全局的配置文件
    @Value("${mybatis.config-location}")
    private String configLocation;


    //事务管理
    @Bean(name = "circleDataSourceTransaction")
    public  PlatformTransactionManager annotationDrivenTransactionManager(@Qualifier("circleDataSource") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }

    @Bean(name = "circleTransactionManager")
    public DataSourceTransactionManager master2TransactionManager(@Qualifier("circleDataSource") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }

    @Bean(name = "circleSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("circleDataSource") DataSource datasource ) throws Exception {
       try{
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(datasource);

        // 读取配置
        sessionFactory.setTypeAliasesPackage(typeAliasesPackage2);
       //设置mybatis-config.xml配置文件位置
       sessionFactory.setConfigLocation(new DefaultResourceLoader().getResource(configLocation));
        //设置mapper.xml文件所在位置
        Resource[] resource = new PathMatchingResourcePatternResolver().getResources(mapperLocations);
        Resource[] resource2 = new PathMatchingResourcePatternResolver().getResources(mapperLocations2);
        List<Resource> rL= new ArrayList<>();
           rL.addAll(Arrays.asList(resource));
           rL.addAll(Arrays.asList(resource2));
        sessionFactory.setMapperLocations(rL.toArray(new Resource[rL.size()]));

        //添加分页插件、打印sql插件
        Interceptor[] plugins = new Interceptor[]{pageHelper(),sqlPrintInterceptor()};
        sessionFactory.setPlugins(plugins);

        return sessionFactory.getObject();
    } catch (IOException e) {
        logger.error("mybatis resolver ws-mapper*xml is error",e);
        return null;
    } catch (Exception e) {
        logger.error("mybatis sqlSessionFactoryBean create error",e);
        return null;
    }
    }


        //将要执行的sql进行日志打印(不想拦截，就把这方法注释掉)

        public SqlPrintInterceptor sqlPrintInterceptor(){
        	return new SqlPrintInterceptor();
        }




        public PageHelper pageHelper() {
            PageHelper pageHelper = new PageHelper();
            Properties p = new Properties();
            p.setProperty("offsetAsPageNum", "true");
            p.setProperty("rowBoundsWithCount", "true");
            p.setProperty("reasonable", "true");
            p.setProperty("returnPageInfo", "check");
            p.setProperty("params", "count=countSql");
            p.setProperty("pageSizeZero", "true");//分页尺寸为0时查询所有纪录不再执行分页
            p.setProperty("reasonable", "true");//页码<=0 查询第一页，页码>=总页数查询最后一页
            p.setProperty("supportMethodsArguments", "true");//支持通过 Mapper 接口参数来传递分页参数
            pageHelper.setProperties(p);
            return pageHelper;
        }



}
