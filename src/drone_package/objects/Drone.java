package drone_package.objects;

public class Drone {
	private int id;
	private boolean isAvailable;
	private int batteryPercentage;
	
	
	public Drone(int id) {
		super();
		this.setId(id);
		this.setAvailable(true);
		this.setBatteryPercentage(100);
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


	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}

	@Override
	public String toString() {
		return "Drone [id=" + id + ", "
				+ "isAvailable=" + isAvailable + ", "
						+ "batteryPercentage=" + batteryPercentage + "]";
	}
}
