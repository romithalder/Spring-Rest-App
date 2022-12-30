package com.cgi.service;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cgi.exception.DepartmentAlreadyExistsException;
import com.cgi.model.Department;
import com.cgi.repository.DepartmentRespository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
	
	@Mock
	private DepartmentRespository dr;
	
	@InjectMocks
	private DeptServiceImpl dsi;
	

	@Test
	public void TestsaveDepartment() throws DepartmentAlreadyExistsException{
		Department d1 = new Department(10, "Accounts", "Chennai"); //user Input
		when(dr.save(any())).thenReturn(d1);
		dsi.saveDepartment(d1);
		verify(dr,times(1)).save(any());
    }
	

	@Test
	public void testGetAllDepartments() {
		Department d1 = new Department(10, "Accounts", "Chennai");//user Input
		dr.save(d1);
		Department d2 = new Department(20, "HR", "Pune"); //user Input
		dr.save(d2);
		Department d3 = new Department(30, "Admin", "Delhi"); //user Input
		dr.save(d3);
		
		List<Department> dList = new ArrayList<>(); // List object is created to store Array of Department
		dList.add(d1);         //retrieved from Database
		dList.add(d2);
		dList.add(d3);
		
		when(dr.findAll()).thenReturn(dList);
		List<Department> dList1 = dsi.getAllDepartments();
		assertEquals(dList,dList1);
		verify(dr,times(1)).save(d1);
		verify(dr,times(1)).findAll();
		
 }
}
