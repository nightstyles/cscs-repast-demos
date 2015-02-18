package DiscreteEventSim;

import java.util.ArrayList;

/**
 * @author Tim Sweda
 * 
 */

public class Queue extends ArrayList<Entity> {
	
	private String type; // Type of queue:  FIFO (default), LIFO, or Priority
	private Stat length; // Number of entities waiting in queue
	private Stat waitTime; // Waiting time of entities in queue
	
	public Queue() {
		type = "FIFO";
		length = new Stat();
		waitTime = new Stat();
		DESimBuilder.qList.add(this);
		DESimBuilder.sList.add(length);
		DESimBuilder.sList.add(waitTime);
	}
	
	public Queue(String type) {
		this.type = type;
		// If type is not recognized, default to FIFO
		if (!type.equals("FIFO") && !type.equals("LIFO") && !type.equals("Priority"))
			this.type = "FIFO";
		length = new Stat();
		waitTime = new Stat();
		DESimBuilder.qList.add(this);
		DESimBuilder.sList.add(length);
		DESimBuilder.sList.add(waitTime);
	}
	
	// Remove next entity from queue
	public Entity pop() {
		length.recordCT(this.size());
		if (this.isEmpty())
			return null;
		waitTime.recordDT(DESimBuilder.schedule.getTickCount()-this.get(0).read());
		return this.remove(0);
	}
	
	// Add incoming entity to queue
	public boolean enqueue(Entity e) {
		length.recordCT(this.size());
		double time = DESimBuilder.schedule.getTickCount();
		if (type.equals("FIFO")) {
			e.stamp(time);
			if (this.add(e))
				return true;
		}
		else if (type.equals("LIFO")) {
			this.add(0, e);
			e.stamp(time);
			return true;
		}
		else if (type.equals("Priority")) {
			int i = 0;
			while (e.getPriority() <= this.get(i).getPriority())
				i++;
			this.add(i, e);
			e.stamp(time);
			return true;
		}
		System.err.println("Unable to add entity to queue");
		return false;
	}
	
	// Let queue know that an entity did not need to wait for service (same as enqueue+pop)
	public void skip() {
		waitTime.recordDT(0);
	}

}