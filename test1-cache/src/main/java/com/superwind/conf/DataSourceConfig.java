package com.superwind.conf;

import com.superwind.dao.DaoPackageMarker;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.io.IOException;

@Slf4j
@Configuration
@EnableTransactionManagement
@MapperScan(basePackageClasses = {DaoPackageMarker.class})
public class DataSourceConfig implements TransactionManagementConfigurer {

    /** 扫描Mapper接口的package name */
    private static final String MODEL_MAPPER_PACKAGE_NAME = "com.superwind.**.model";

    /** 资源文件的路径pattern */
    private static final String MODEL_XML_RESOURCE_PATTERN = "classpath:com/superwind/**/*.xml";

    @Autowired
    private Environment env;
    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage(MODEL_MAPPER_PACKAGE_NAME);

        SqlSessionFactory sqlFactory = null;
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources(MODEL_XML_RESOURCE_PATTERN));
            sqlFactory = bean.getObject();
        } catch (IOException e) {
            log.error("Reading mapper configuration file fail", e);
        } catch (Exception e) {
            log.error("Getting SqlSessionFactory instance fail", e);
        }

        return sqlFactory;
    }

    @Bean(name = "platformTransactionManager")
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
