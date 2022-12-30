package com.cgi.service;

import java.util.List;

import com.cgi.exception.DepartmentAlreadyExistsException;
import com.cgi.model.Department;

public interface DepartmentService {
	
	    Department saveDepartment(Department dept)throws DepartmentAlreadyExistsException; 
	    List<Department> getAllDepartments();
	    void deleteDepartmentBydeptno(int deptno);

}
