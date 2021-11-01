package drone_package;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import drone_package.details.MyBoolHolder;
import drone_package.objects.Drone;

public class DroneSystem { // Singelton
	private static int numberOfDrones = 2;
	private static int droneFlightTime = 2000; // ms
	private static DroneSystem instance = null;
	private ArrayList<Drone> drones = new ArrayList<Drone>();
	private Queue<Drone> queue = new LinkedList<Drone>();

	public static DroneSystem getInstance() {
		if (instance == null) {
			instance = new DroneSystem();
		}
		return instance;
	}
	
	private DroneSystem() {
		super();
		this.createDrones(numberOfDrones);
	}
	
	private void createDrones(int numberOfDrones) {
		for (int i = 0; i < numberOfDrones; ++i) {
			drones.add(new Drone());
			queue.add(drones.get(i)); 
		}
	}
	
	public Drone getAvailableDrone() {
		Drone drone = queue.remove();
		drone.setAvailable(false);
		return drone;
	}
	
	public Drone getDrone(int id) {
		return drones.get(id);
	}
	
	public void returnDroneToBase(int id) {
		Drone drone = getDrone(id);
		drone.setAvailable(true);
		chargeDrone(id);
		queue.add(drone);
	}
	
	
	public void summonDrone(JFrame frame, MyBoolHolder droneArrived) {
		JOptionPane.showMessageDialog(frame, 
				"Drone has Summoned. please wait for " + droneFlightTime/1000 + " Sec...");
		Timer timer = new Timer();
		TimerTask summonDroneTask = new TimerTask() {
			@Override
			public void run() {
				Drone drone = getAvailableDrone();
				drone.decreaseAirTime(droneFlightTime);
				JOptionPane.showMessageDialog(frame, 
						"Drone number " + drone.getId() + " has arrived.\r\nYou can assign it to destination.");
				droneArrived.setValue(true);
				droneArrived.setDroneId(drone.getId());
			}
		};
		
		timer.schedule(summonDroneTask, droneFlightTime);
	}
	
	public void assigneDrone(JFrame frame, int droneId) {
		JOptionPane.showMessageDialog(frame, 
				"Drone has assigned to destination succesfuly.\r\n"
				+ "ETA: " + droneFlightTime/1000 + " Sec");
		Timer timer = new Timer();
		TimerTask assignDroneTask = new TimerTask() {
			@Override
			public void run() {
				Drone drone = getDrone(droneId);
				drone.decreaseAirTime(droneFlightTime);
				JOptionPane.showMessageDialog(frame, 
						"Drone, number " + drone.getId() + ", has arrived to destination succesfully.");
				returnDroneToBase(droneId);
			}
		};
		
		timer.schedule(assignDroneTask, droneFlightTime);
	}
	
	private void chargeDrone(int id) {
		getDrone(id).setAirTime(-1).setBatteryPercentage(-1);
	}
	
}
