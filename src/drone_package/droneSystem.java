package drone_package;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import drone_package.objects.Drone;

public class droneSystem {
	private ArrayList<Drone> drones = new ArrayList<Drone>();
	private Queue<Drone> queue = new LinkedList<Drone>();

	public droneSystem(int numberOfDrones) {
		super();
		this.createDrones(numberOfDrones);
	}
	
	private void createDrones(int numberOfDrones) {
		for (int i = 0; i < numberOfDrones; ++i) {
			drones.add(new Drone());
			queue.add(drones.get(i));
		}
	}
	
	public ArrayList<Drone> getDrones() {
		return drones;
	}
	
	public Queue<Drone> getQueue() {
		return queue;
	}
	
}
