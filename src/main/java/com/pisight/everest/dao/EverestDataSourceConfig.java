package com.pisight.everest.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableJpaRepositories(basePackages="com.pisight.everest.repository", entityManagerFactoryRef="everestEntityManagerFactory")
@EnableTransactionManagement
public class EverestDataSourceConfig {
	
	
	@Bean(name="everestDataSource")
	@Primary
	@ConfigurationProperties(prefix="datasource.everest")
	public DataSource everestDataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean everestEntityManagerFactory(
	        EntityManagerFactoryBuilder builder) {
	    return builder
	            .dataSource(everestDataSource())
	            .packages("com.pisight.everest.repository")
	            .persistenceUnit("everestEntityManager")
	            .build(); 
	}
	
	@Bean
	public EntityManager everestEntityManager(EntityManagerFactory entityManagerFactory) {
		return entityManagerFactory.createEntityManager();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(everestEntityManagerFactory(builder).getObject());
		
		return txManager;
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/everest/**");
            }
        };
    }
}
