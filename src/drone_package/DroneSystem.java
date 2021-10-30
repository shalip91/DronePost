package drone_package;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import drone_package.objects.Drone;

public class DroneSystem { // Singelton
	private static DroneSystem instance = null;
	private ArrayList<Drone> drones = new ArrayList<Drone>();
	private Queue<Drone> queue = new LinkedList<Drone>();

	public static DroneSystem getInstance(int numberOfDrones) {
		if (instance == null) {
			instance = new DroneSystem(numberOfDrones);
		}
		return instance;
	}
	
	private DroneSystem(int numberOfDrones) {
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
//		Drone drone = queue.remove();
//		drone.setAvailable(false);
//		return drones;
		return drones;
	}
	
	public void print(JFrame frame) {
		JOptionPane.showMessageDialog(frame, "Drone has arrived");
	}

	
}
