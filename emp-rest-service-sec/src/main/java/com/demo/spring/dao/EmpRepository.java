package com.demo.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.demo.spring.entity.Emp;


public interface EmpRepository extends JpaRepository<Emp, Integer> {

}
