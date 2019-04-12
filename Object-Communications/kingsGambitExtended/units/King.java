package kingsGambit.units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kingsGambit.interfaces.Attackable;
import kingsGambit.interfaces.Killable;



public class King extends BaseUnit implements Killable, Attackable {

	private List<BaseUnit> allFootmen;
	private List<BaseUnit> allRoyalGuards;
	
	
	public King(String name) {
		super(name);
		this.allFootmen = new ArrayList<BaseUnit>();
		this.allRoyalGuards = new ArrayList<BaseUnit>();
	}
	
	@Override
	public void addFootmen(String footmen) {
		Arrays.stream(footmen.split("[ ]+"))
			  .forEach(a -> {
				  BaseUnit footman = new Footman(a);
				  this.allFootmen.add(footman);
			  });			
		
	}

	public void addRoyalGuard(String royalGuard) {
		Arrays.stream(royalGuard.split("[ ]+"))
		  .forEach(a -> {
			  BaseUnit guard = new RoyalGuard(a);
			  this.allRoyalGuards.add(guard);
		  });	
	}


	@Override
	public void killUnit(String name) {
		for(int i = 0; i < this.allFootmen.size(); i++) {
			String currentFootmanName = this.allFootmen.get(i).getName();
				if(currentFootmanName.equals(name)) {
					int currentHits = this.allFootmen.get(i).getHits();
					currentHits--;
					this.allFootmen.get(i).setHits(currentHits);
						if(currentHits == 0) {
							this.allFootmen.remove(i);
						}
				}
		}
		
		for(int i = 0; i < this.allRoyalGuards.size(); i++) {
			String currentGuardName = this.allRoyalGuards.get(i).getName();
				if(currentGuardName.equals(name)) {
					int currentHits = this.allRoyalGuards.get(i).getHits();
					currentHits--;
					this.allRoyalGuards.get(i).setHits(currentHits);
					if(currentHits == 0) {
						this.allRoyalGuards.remove(i);
					}
					
				}
		}
	}

	
	@Override
	public String attackKing() {
		StringBuilder sb = new StringBuilder();
		sb.append("King ").append(this.getName()).append(" is under attack!")
		  .append(System.lineSeparator());
			
			for(int i = 0; i < this.allRoyalGuards.size(); i++) {
				String currentName = this.allRoyalGuards.get(i).getName();
				sb.append("Royal Guard ").append(currentName).append(" is defending!")
				  .append(System.lineSeparator());	
			}
		
			for(int i = 0; i < this.allFootmen.size(); i++) {
				String currentName = this.allFootmen.get(i).getName();
				sb.append("Footman ").append(currentName).append(" is panicking!")
				  .append(System.lineSeparator());	
			}
			
			return sb.toString();
	}
}

















