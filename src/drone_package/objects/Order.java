package drone_package.objects;
import drone_package.dataBase.DronePostDB;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
	// private static int totalOrders = 0;
	private static DronePostDB Db = new DronePostDB();
	private static int totalOrders = Db.getOrdersIdCount();
	private static Date utilDate = new java.util.Date();
	
	private int id;
	private String srcName;
	private String dstName;
	private Timestamp dateTime;
	
	public Order(String srcName, String dstName) {
		super();
		this.setId(totalOrders++);
		this.setSrcName(srcName);
		this.setDstName(dstName);
		this.dateTime = new Timestamp(utilDate.getTime());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSrcName() {
		return srcName;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}

	public String getDstName() {
		return dstName;
	}

	public void setDstName(String dstName) {
		this.dstName = dstName;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", "
				+ "srcName=" + srcName + ", "
						+ "dstName=" + dstName + ", "
								+ "date=" + dateTime.toString() + "]";
	}
	
	
}
