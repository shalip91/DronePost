package drone_package.objects;

public class Drone {
	private static int droneAirTime = 20000; // [ms] 
	private static int totalDrones = 0;
	private int id;
	private boolean isAvailable;
	private int batteryPercentage;
	private int airTime;
	
	public Drone() {
		super();
		this.setId(totalDrones++);
		this.setAvailable(true);
		this.setBatteryPercentage(100);
		this.setAirTime(droneAirTime);
	}
	
	public void decreaseAirTime(int flightTime) {
		setAirTime(getAirTime() - flightTime);
		setBatteryPercentage(getBatteryPercentage() - 100*(flightTime/droneAirTime));
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	public int getBatteryPercentage() {
		return batteryPercentage;
	}


	public Drone setBatteryPercentage(int batteryPercentage) {
		
		if (airTime == -1) {
			this.batteryPercentage = 100;
		}else {
			this.batteryPercentage = batteryPercentage;
		}
		return this;
	}

	public Drone setAirTime(int airTime) {
		if (airTime == -1) {
			this.airTime = droneAirTime;
		}else {
			this.airTime = airTime;
		}
		return this;
	}

	public int getAirTime() {
		return airTime;
	}
	
	@Override
	public String toString() {
		return "Drone [id=" + id + ", "
				+ "isAvailable=" + isAvailable + ", "
						+ "batteryPercentage=" + batteryPercentage + "]";
	}

}
