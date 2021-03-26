package com.jacknie.example;

import com.jacknie.example.test1.Test1;
import com.jacknie.example.test1.Test1Repository;
import com.jacknie.example.test2.Test2;
import com.jacknie.example.test2.Test2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TransactionTestService {

    @Autowired
    private Test1Repository test1Repository;

    @Autowired
    private Test2Repository test2Repository;

    public Pair<Long, Long> service() {
        var test1 = new Test1();
        test1.setName("테스트1");
        test1Repository.save(test1);
        var test2 = new Test2();
        test2.setName("테스트2");
        test2Repository.save(test2);
        return Pair.of(test1Repository.count(), test2Repository.count());
    }
}
