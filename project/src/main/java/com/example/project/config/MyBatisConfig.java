package com.example.project.config;

import com.example.project.common.DataSourceEnum;
import com.example.project.common.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan("com.example.project.dao")
public class MyBatisConfig {

    @Primary
    @Bean("DS1")
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource ds1DataSource() throws Exception {
        return DataSourceBuilder.create().build();
    }

    @Bean("DS2")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource ds2DataSource() throws Exception {
        return DataSourceBuilder.create().build();
    }

    @Bean("dynamicDataSource")
    public DynamicDataSource dynamicDataSource(@Qualifier("DS1") DataSource dataSource1,
                                               @Qualifier("DS2") DataSource dataSource2) {
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put(DataSourceEnum.DS1, dataSource1);
        targetDataSources.put(DataSourceEnum.DS2, dataSource2);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// This method is AbstractRoutingDataSource's method
        dataSource.setDefaultTargetDataSource(dataSource1);// The default datasource setting is test_project

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DynamicDataSource dynamicDataSource,
                                               @Value("mybatis.typeAliasesPackage") String typeAliasesPackage,
                                               @Value("mybatis.mapperLocations") String mapperLocations) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dynamicDataSource);

        // The next two sentences are for *.xml files only, if the XML file is not needed for the entire
        // persistence layer operation (only annotations will do), they are not added
        sessionFactory.setTypeAliasesPackage("com.example.project.model"); //Specify base package
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));

        return sessionFactory.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

}
