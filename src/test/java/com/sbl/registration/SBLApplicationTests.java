package com.sbl.registration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class SBLApplicationTests {

	@Autowired
	private EmpService service;

	@MockBean
	private EmpRepository repo;

	/**
	 * when repo is called it returns mock objects instead of calling from the database
	 *
	 *  assertequals checks if the mock employee returned by the service
	 * 	contains the same id as empid dummy variable
	 */

	@Test
	public void GetEmpByIdTest()
	{
		int empid = 123;

		when( repo.findByempID(empid))
			.thenReturn( new Employee(1, 123, "empusername", "empfirstname", "emplastname", "emp@company.com"));

		assertEquals(empid, service.GetEmpById(empid).getEmpID());
	}

	/**
	 * when repo is called it returns mock objects instead of calling from the database
	 *
	 *  assertequals checks if the mock employee returned by the service
	 * 	contains the same username as the Dummy string maruV
	 */

	@Test
	public void GetEmpByUserTest()
	{
		String username = "maruV";

		when( repo.findByempUName(username))
				.thenReturn( new Employee(1, 123, "maruV", "empfirstname", "emplastname", "emp@company.com"));

		assertEquals(username, service.GetEmpByUser(username).getEmpUName());
	}

	/**
	 * dummy employee object is created
	 * passed into the mock repo
	 * assertequals if the dummy object and the mock repo saved object have same usernames
	 */

	@Test
	public void createEmployeeTest()
	{
		Employee employee = new Employee(1, 123, "maruV", "empfirstname", "emplastname", "emp@company.com");
		when (repo.save(employee))
			.thenReturn(employee);

		assertEquals(employee.getEmpUName(), service.createEmployee(employee));

	}
}
