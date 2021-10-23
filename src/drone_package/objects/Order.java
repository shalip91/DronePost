package drone_package.objects;

import java.time.LocalDateTime;

public class Order {
	private int id;
	private String srcName;
	private String dstName;
	private LocalDateTime date;
	
	public Order(int id, String srcName, String dstName, LocalDateTime date) {
		super();
		this.setId(id);
		this.setSrcName(srcName);
		this.setDstName(dstName);
		this.setDate(date);
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

	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}

	public String getDstName() {
		return dstName;
	}

	public void setDstName(String dstName) {
		this.dstName = dstName;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
