package systemSplit.interfaces;

import java.util.List;

import systemSplit.softwareComponents.BaseSoftware;

public interface Hardwarable {

	public void setMaximumCapacity(int maximumCapacity);
	public void setMaximumMemory(int maximumMemory);
	public int getMaximumCapacity();
	public int getMaximumMemory();
	public List<BaseSoftware> getAllSoftware();
	public String getType();
	public void setType(String type);
}
