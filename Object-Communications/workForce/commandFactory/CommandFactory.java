package workForce.commandFactory;

import workForce.employees.BaseEmployee;
import workForce.employees.PartTimeEmployee;
import workForce.employees.StandartEmployee;
import workForce.jobs.Job;
import workForce.repository.EmployeeRepository;
import workForce.repository.JobRepository;

public class CommandFactory {

	private JobRepository jr;
	private EmployeeRepository er;
	
	public CommandFactory() {
		this.jr = new JobRepository();
		this.er = new EmployeeRepository();
	}
	
	
	public void parseCommand(String input[]) {
		
		String command = input[0];
		
			if(command.equals("StandartEmployee")) {
				addStandartEmployee(input[1]);
			} else if (command.equals("PartTimeEmployee")) {
				addPartTimeEmployee(input[1]);
			} else if (command.equals("Job")) {
				addJob(input[1], input[2], input[3]);
			} else if (command.equals("Pass")) {
				String result = passWeek();
				if(result.trim() != "") {
					System.out.print(result);
				}
				
			} else if (command.equals("Status")){
					String result = printJobsStatus();
					if(result.trim() != "") {
						System.out.print(result);
					}
			}
		
		
	}

	// Print Active
	private String printJobsStatus() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < this.jr.getJobRepository().size(); i++) {
			String result = "";
			int hoursLeft = this.jr.getJobRepository().get(i).getWorkingHoursRequired();
			String jobName = this.jr.getJobRepository().get(i).getJobName();	
				if(hoursLeft > 0) {
					result = String.format("Job: %s Hours Remaining: %d%n", jobName, hoursLeft);
					sb.append(result);
				}
		}
		return sb.toString();
	}


	// Passing a week print done
	private String passWeek() {
		StringBuilder sb = new StringBuilder();
		String result = "";
		for(int i = 0; i < this.jr.getJobRepository().size(); i++) {
			int hoursLeft = this.jr.getJobRepository().get(i).update();
				if(hoursLeft <= 0) {
					String jobName = this.jr.getJobRepository().get(i).getJobName();
					result = String.format("Job %s done!%n", jobName, hoursLeft);
					this.jr.getJobRepository().remove(i);
					i = i - 1;
				}
				sb.append(result);
		}
		return sb.toString();
	}


	// Adding a job
	private void addJob(String jobName, String jobTime, String employeeName) {
		BaseEmployee employee = getEmployee(employeeName);
		Job job = new Job(jobName, Integer.valueOf(jobTime), employee);
		this.jr.addJob(job);
	}

	// Get the needed employee
	private BaseEmployee getEmployee(String employeeName) {
		BaseEmployee employee = null;
		for(int i = 0 ; i < this.er.getEmployeeRepository().size(); i++) {
			if(this.er.getEmployeeRepository().get(i).getName().equals(employeeName)) {
				employee = this.er.getEmployeeRepository().get(i);
			}
		}
		return employee;
	}


	// Adding part time employee
	private void addPartTimeEmployee(String name) {
		BaseEmployee employee = new PartTimeEmployee(name);
		this.er.addEmployee(employee);
	}

	
	// Adding full time employee
	private void addStandartEmployee(String name) {
		BaseEmployee employee = new StandartEmployee(name);
		this.er.addEmployee(employee);
	}
}
