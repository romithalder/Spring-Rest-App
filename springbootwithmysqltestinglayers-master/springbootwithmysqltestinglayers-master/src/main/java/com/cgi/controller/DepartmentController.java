package com.cgi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.exception.DepartmentAlreadyExistsException;
import com.cgi.model.Department;
import com.cgi.service.DepartmentService;

@RestController
@RequestMapping("/api/vi")
public class DepartmentController {
	
	
	private DepartmentService deptServ;

	@Autowired
	public DepartmentController(DepartmentService deptServ) {
			this.deptServ = deptServ;
	}
	
	@PostMapping("/dept")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department dept )throws DepartmentAlreadyExistsException{
        Department saveddept = deptServ.saveDepartment(dept);
        return new ResponseEntity<>(saveddept, HttpStatus.CREATED);
    }
	
	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getAllDepartments(){
        return new ResponseEntity<List<Department>>((List<Department>)deptServ.getAllDepartments(),HttpStatus.OK);
    }
	
	@DeleteMapping("/dept/{deptno}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable int deptno){
        deptServ.deleteDepartmentBydeptno(deptno);
        return ResponseEntity.noContent().build();
    }
	
	
	
	
	
	

	
	
	
	
	

}
