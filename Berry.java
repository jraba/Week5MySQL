package entity;

public class Berry {

	private long berry_id;
	private String name;


	public Berry(long berry_id, String name) {
		this.berry_id = berry_id;
		this.name = name;
	
	}

	public long getBerryId () {
		return berry_id;
	}

	public void setBerryId (long berry_id) {
		this.berry_id = berry_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	@Override
	public String toString() {
		return "Berry [berry_id=" + berry_id + ", name=" + name + "]";
	}

}
