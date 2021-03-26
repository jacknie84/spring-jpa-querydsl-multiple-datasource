package com.jacknie.example.test1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface Test1Repository extends JpaRepository<Test1, Long>, QuerydslPredicateExecutor<Test1> {

}
