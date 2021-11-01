package drone_package.details;

public class MyBoolHolder {
	private boolean value;
	private int droneId;

	public MyBoolHolder(boolean value) {
		super();
		this.value = value;
		this.droneId = -1;
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public int getDroneId() {
		return droneId;
	}

	public void setDroneId(int droneId) {
		this.droneId = droneId;
	}

}
