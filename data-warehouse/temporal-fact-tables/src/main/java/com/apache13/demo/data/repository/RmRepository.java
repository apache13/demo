package com.apache13.demo.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apache13.demo.data.entity.Rm;

@Repository
public interface RmRepository extends CrudRepository<Rm, Integer>{

}
