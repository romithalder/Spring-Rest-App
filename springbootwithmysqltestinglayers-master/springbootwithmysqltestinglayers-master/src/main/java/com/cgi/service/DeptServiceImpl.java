package com.cgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.exception.DepartmentAlreadyExistsException;
import com.cgi.model.Department;
import com.cgi.repository.DepartmentRespository;

@Service
public class DeptServiceImpl implements DepartmentService {
	
	
	private DepartmentRespository deptRepo;
	
	
	@Autowired
	public DeptServiceImpl(DepartmentRespository deptRepo) {
		super();
		this.deptRepo = deptRepo;
	}

	@Override
	public Department saveDepartment(Department dept) throws DepartmentAlreadyExistsException  {
		if(deptRepo.existsById(dept.getDeptno())) {
			throw new DepartmentAlreadyExistsException();
		}
		Department savedDept = deptRepo.save(dept);
		return savedDept;
	}

	@Override
	public List<Department> getAllDepartments() {
			return (List<Department>) deptRepo.findAll();
	}
	
	@Override
	public void deleteDepartmentBydeptno(int deptno) {
		deptRepo.deleteById(deptno);

	}

}
