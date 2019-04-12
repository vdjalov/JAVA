package kingsGambit.units;



public abstract class BaseUnit{

	private String name;
	private int hits;
	
		public BaseUnit(String name) {
			this.name = name;
			this.setHits(2);
		}
		
		public String getName() {
			return this.name;
		}

		public void addFootmen(String string){};
		public void addRoyalGuard(String string){}

		public int getHits() {
			return hits;
		}

		public void setHits(int hits) {
			this.hits = hits;
		};	
}
