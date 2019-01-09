package cisco.cmad.networkhealth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="syslogevents")
public class Syslog {

	
	@Id
	@GeneratedValue
	private int	id; 
	
	@Column(name="timestamp")
	private String timeStamp;
	private String message;
	
	@Column(name="ipaddress")
	private String ipAddress;
	
	@Column(name="type")
	private String eventType;
	
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getEnumType() {
		return eventType;
	}
	public void setEnumType(String eventType) {
		this.eventType = eventType;
	} 
}
