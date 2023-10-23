package com.npci;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.npci.beans.Employee;
import com.npci.controller.EmployeeController;
import com.npci.service.EmployeeService;


@WebMvcTest(value = EmployeeController.class)
class SpringBootDbApplicationTests {

	@Autowired
	private MockMvc mvc;

	
	@MockBean
	private EmployeeService employeeService;
	
	@Test
	public void testEmployeeWithMockService() throws Exception {
		Employee emp = new Employee();	emp.setId(100);	emp.setName("Raj");	emp.setSalary(12000);
		
		given(employeeService.findEmployee(100)).willReturn(emp);
		
		String empJson = "{\"id\":100,\"name\":\"Raj\",\"salary\":12000.0}";
		
		try {
			mvc.perform(get("/api/employees/100").contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk()).andExpect(content().json(empJson));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
