package drone_package;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import drone_package.objects.Drone;

public class DroneSystem {
	private ArrayList<Drone> drones = new ArrayList<Drone>();
	private Queue<Drone> queue = new LinkedList<Drone>();

	public DroneSystem(int numberOfDrones) {
		super();
		this.createDrones(numberOfDrones);
	}
	
	private void createDrones(int numberOfDrones) {
		for (int i = 0; i < numberOfDrones; ++i) {
			drones.add(new Drone(i));
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
