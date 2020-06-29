package com.blog.cms.properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.blog.cms.dao.c",sqlSessionFactoryRef = "cmsSqlsessionFactory")
public class DataSourceCMS {
    /**
     * 返回数据源
     * @return
     */
    @Bean(name = "cmsDataSoruce")
    @ConfigurationProperties(prefix="spring.datasource.data-cms")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 返回数据库会话工厂
     * @return
     */
    @Bean(name = "cmsSqlsessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("cmsDataSoruce")DataSource dataSource) throws  Exception{
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/c/**/*Mapper.xml"));
        return  bean.getObject();
    }

    /**
     * 返回数据库会话模板
     * @return
     */
    @Bean(name = "cmsSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("cmsSqlsessionFactory")SqlSessionFactory factory){
        return  new SqlSessionTemplate(factory);
    }
    /**
     * 返回数据库的事务
     * @param ds
     * @return
     */
    @Bean(name = "cmsTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("cmsDataSoruce") DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
}
