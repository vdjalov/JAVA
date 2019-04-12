package workForce.repository;

import java.util.ArrayList;
import java.util.List;
import workForce.jobs.Job;

public class JobRepository {

	private List<Job> repository;
	
		public JobRepository() {
			this.repository = new ArrayList<Job>(); 
		}
		
		
		public void addJob(Job job) {
			this.repository.add(job);
		}
		
		
		public List<Job> getJobRepository() {
			return this.repository;
	}
}
