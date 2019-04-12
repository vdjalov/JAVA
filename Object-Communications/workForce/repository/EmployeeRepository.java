package workForce.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import workForce.employees.BaseEmployee;


public class EmployeeRepository {

	private List<BaseEmployee> employeeRepository;
	
	public  EmployeeRepository() {
		this.employeeRepository = new ArrayList<BaseEmployee>();
	}
	
	
	public void addEmployee(BaseEmployee employee) {
		this.employeeRepository.add(employee);
	}
	
	
	public List<BaseEmployee> getEmployeeRepository() {
			return this.employeeRepository;
	}
}
