package workForce.employees;

public class StandartEmployee extends BaseEmployee {
	private int DEFAULT_WORK_HOURS_PER_WEEK = 40;
	
	
	
	public StandartEmployee(String name) {
		super(name);
		super.setWorkHoursPerWeek(DEFAULT_WORK_HOURS_PER_WEEK);
	}

	
	
	
}
