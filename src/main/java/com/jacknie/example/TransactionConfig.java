package com.jacknie.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
public class TransactionConfig {

    @Primary
    @Bean
    public PlatformTransactionManager chainedTransactionManager(List<PlatformTransactionManager> txManagers) {
        return new ChainedTransactionManager(txManagers.toArray(new PlatformTransactionManager[0]));
    }
}
