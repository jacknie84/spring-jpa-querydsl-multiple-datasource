package com.jacknie.example.test2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface Test2Repository extends JpaRepository<Test2, Long>, QuerydslPredicateExecutor<Test2> {

}
