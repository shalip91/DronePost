package drone_package.objects;

import java.sql.Timestamp;
import java.util.Date;

public class Message {
	private static int totalMSG = 0;
	private static Date utilDate = new java.util.Date();
	
	private int id;
	private String receiver;
	private String content;
	private Timestamp dateTime;
	
	
	public Message(String receiver, String content) {
		super();
		
		this.setId(totalMSG++);
		this.setReceiver(receiver);
		this.setContent(content);
		this.setDateTime(new Timestamp(utilDate.getTime()));
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", "
				+ "content=" + content + ", "
				+ "dateTime=" + dateTime.toString() + "]";
	}
}
