package cisco.cmad.networkhealth.entity;

public class CounterStatitics {

	private String counterType;
	
	private int count;
	
	public CounterStatitics(String type, int count) {
		this.count = count;
		this.counterType = type;
	}

	public String getCounterType() {
		return counterType;
	}

	public void setCounterType(String counterType) {
		this.counterType = counterType;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
