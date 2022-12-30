package com.cgi.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cgi.model.Department;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DepartmentRespositoryTest {
	
	
	@Autowired
	private DepartmentRespository deptRepo;
	
	@Test
	public void givenDepartmentshouldReturnDepartmentObject() {
		
		Department d1 = new Department(10,"Accounts", "Chennai"); //User input
		deptRepo.save(d1); //Data is saved into Database
		Department d2 = deptRepo.findById(d1.getDeptno()).get(); // Data is retrieved from Database
		assertNotNull(d2);
		assertEquals(d1.getDname(), d2.getDname());
			
	}

	@Test
	public void getAllmustReturnAllDepartments() {
		Department d3 = new Department(20,"Sales", "Pune");//User Input
		Department d4 = new Department(30,"Admin", "Delhi"); // User Input
		deptRepo.save(d3); //save the Data in database
		deptRepo.save(d4); // save the Data in Database
		List <Department> deptList = (List<Department>) deptRepo.findAll();
		assertEquals("Admin",deptList.get(2).getDname());
			
	}
	

}
