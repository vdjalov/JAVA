package workForce.employees;

public abstract class BaseEmployee {

	private String name;
	private int workHoursPerWeek;
	
		public BaseEmployee(String name) {
			this.name = name;
			this.setWorkHoursPerWeek(0);
		}

		public String getName() {
			return name;
		}
		

		public int getWorkHoursPerWeek() {
			return workHoursPerWeek;
		}

		protected void setWorkHoursPerWeek(int workHoursPerWeek) {
			this.workHoursPerWeek = workHoursPerWeek;
		}
	
}
