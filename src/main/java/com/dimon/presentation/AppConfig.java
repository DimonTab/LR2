package com.dimon.presentation;

import com.dimon.domain.StudentRepository;
import com.dimon.domain.StudentRepositoryImpl;
import com.dimon.services.ApplicationService;
import com.dimon.services.ApplicationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@EnableTransactionManagement()
public class AppConfig {

    @Bean
    public ApplicationService getApplicationService() {
        return new ApplicationServiceImpl(getBookRepository());
    }

    @Bean
    public StudentRepository getBookRepository() {
        return new StudentRepositoryImpl();
    }

    @Bean(name = "manager")
    public EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    @Bean
    public EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("lab5");
    }

    @Bean
    public PlatformTransactionManager userTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getEntityManagerFactory());
        return transactionManager;
    }

}
