package com.cgi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cgi.model.Department;

@Repository
public interface DepartmentRespository extends CrudRepository<Department, Integer> {

}
