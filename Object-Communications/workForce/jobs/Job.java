package workForce.jobs;

import workForce.employees.BaseEmployee;

public class Job {

	private String jobName;
	private int workingHoursRequired;
	private BaseEmployee employee;
		
	
	public Job(String jobName, int workingHoursRequired, BaseEmployee employee) {
		this.setJobName(jobName);
		this.workingHoursRequired = workingHoursRequired;
		this.employee = employee;
	}

	
	public int update() {
		 return this.workingHoursRequired-=this.employee.getWorkHoursPerWeek();
	}
	
	
	public int getWorkingHoursRequired() {
		return this.workingHoursRequired;
	}


	public String getJobName() {
		return jobName;
	}


	private void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	public BaseEmployee getEmployee() {
		return this.employee;
	}
	
}
