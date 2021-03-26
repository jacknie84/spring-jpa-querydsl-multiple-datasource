package com.jacknie.example;

import com.jacknie.example.test1.Test1;
import com.jacknie.example.test1.Test1Repository;
import com.jacknie.example.test2.Test2;
import com.jacknie.example.test2.Test2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.util.Pair;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class JacknieExampleApplication implements CommandLineRunner {

    @Autowired
    private TransactionTestService testService;

    public static void main(String[] args) {
        SpringApplication.run(JacknieExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Pair<Long, Long> countPair = testService.service();
        System.out.printf("Test1Count: %d, Test2Count: %d\n", countPair.getFirst(), countPair.getSecond());
        System.exit(0);
    }
}
