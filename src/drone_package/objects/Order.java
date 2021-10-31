package drone_package.objects;
import drone_package.dataBase.DronePostDB;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
	private static DronePostDB Db = new DronePostDB();
	private static Date utilDate = new java.util.Date();
	
	private String srcName;
	private String dstName;
	private Timestamp dateTime;
	
	public Order(String srcName, String dstName) {
		super();
		this.setSrcName(srcName);
		this.setDstName(dstName);
		this.setDateTime(new Timestamp(utilDate.getTime()));
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
		return "srcName=" + srcName + ", "
						+ "dstName=" + dstName + ", "
								+ "date=" + dateTime.toString() + "]";
	}
	
	
}
