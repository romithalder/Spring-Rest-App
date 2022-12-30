package com.cgi.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cgi.model.Department;
import com.cgi.service.DepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(MockitoExtension.class)
public class DepartmentControllerTest {
	
    @Autowired
    private MockMvc mockMvc;
	
    @Mock
    private DepartmentService deptService;
    private Department dept;
    private List<Department> deptList;

    @InjectMocks
    private DepartmentController deptController;
    
    @BeforeEach
    public void setUp(){
        dept = new Department(1,"FIN", "Pune");
        mockMvc= MockMvcBuilders.standaloneSetup(deptController).build();
    }
    
    
    @Test
    public void saveDeptControllerTest() throws Exception {
        when(deptService.saveDepartment(any())).thenReturn(dept);
        mockMvc.perform(post("/api/vi/dept")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(dept)))
                .andExpect(status().isCreated());
        verify(deptService, times(1)).saveDepartment(any());

    }
    
    @Test
    public void getAllDepartmentControllerTest() throws Exception{
        when(deptService.getAllDepartments()).thenReturn(deptList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(dept)))
                .andDo(MockMvcResultHandlers.print());
        verify(deptService, times(1)).getAllDepartments();

    }
    


	public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}