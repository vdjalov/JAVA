package workForce.employees;

public class PartTimeEmployee extends BaseEmployee {
	
	private int DEFAULT_WORK_HOURS_PER_WEEK = 20;
	
	public PartTimeEmployee(String name) {
		super(name);
		super.setWorkHoursPerWeek(DEFAULT_WORK_HOURS_PER_WEEK);
	}

}
