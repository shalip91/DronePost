package drone_package.objects;

import java.time.LocalDateTime;

public class Message {
	private String content;
	private LocalDateTime date;
	
	public Message(String content, LocalDateTime date) {
		super();
		this.setContent(content);
		this.setDate(date);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
