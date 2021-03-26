package com.jacknie.example;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.jacknie.example.test2",
        entityManagerFactoryRef = "entityManagerFactory2",
        transactionManagerRef = "transactionManager2")
public class JpaConfig2 {

    @Bean
    public DataSource dataSource2() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .url("jdbc:h2:mem:test2-db")
                .username("sa")
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory2(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource2())
                .packages("com.jacknie.example.test2")
                .properties(Map.of(
                        AvailableSettings.HBM2DDL_AUTO, "update",
                        AvailableSettings.SHOW_SQL, "true"
                ))
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager2(
            @Qualifier("entityManagerFactory2") EntityManagerFactory entityManagerFactory
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
