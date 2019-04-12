package eventImplementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

		private String name;
		private List<NameChangeListener> listeners;
	
		
		public Dispatcher(String name, Handler handler) {
			this.listeners = new ArrayList<NameChangeListener>();
			this.addListener(handler);
			this.setName(name);
		}
		
		// Adding Name change listener
		public void addListener(NameChangeListener ncl) {
			this.listeners.add(ncl);	
		}
		
		// Removing by index
		public void removeNameChangeListener(int index) {
			 this.listeners.remove(index);
		}
		
		// Broadcast as soon as the name is changed
		public void fireNameChangeEvent(String name) {
			Event event = new Event(name);
			this.listeners.forEach(listener -> {
				listener.handleChangedName(event);
			});
		}

		private void setName(String name) {
			this.name = name;
		}
		
		
		// Change name
		public void changeName(String name) {
			this.setName(name);
			this.fireNameChangeEvent(name);
			
		}
}
