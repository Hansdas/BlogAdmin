package com.blog.cms.properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.blog.cms.dao.b",sqlSessionFactoryRef = "blogSqlsessionFactory")
public class DataSourceBLOG {
    /**
     * 返回数据源
     * @return
     */
    @Bean(name = "blogDataSoruce")
    @ConfigurationProperties(prefix="spring.datasource.data-blog")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 返回数据库会话工厂
     * @return
     */
    @Bean(name = "blogSqlsessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("blogDataSoruce")DataSource dataSource) throws  Exception{
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/b/**/*Mapper.xml"));
        return  bean.getObject();
    }

    /**
     * 返回数据库会话模板
     * @return
     */
    @Bean(name = "blogSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("blogSqlsessionFactory")SqlSessionFactory factory){
        return  new SqlSessionTemplate(factory);
    }
    /**
     * 返回数据库的事务
     * @param dataSource
     * @return
     */
    @Bean(name = "blogTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("blogDataSoruce") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 返回jdbc
     * @param dataSource
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("blogDataSoruce") DataSource dataSource){
        return  new JdbcTemplate(dataSource);
    }
}
