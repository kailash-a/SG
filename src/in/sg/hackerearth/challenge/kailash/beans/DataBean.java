package in.sg.hackerearth.challenge.kailash.beans;

import org.springframework.stereotype.Component;

@Component
public class DataBean {

	private String id;
	private String status;
	private String race;
	private String weight;
	private String height;
	private String is_veg;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getIs_veg() {
		return is_veg;
	}
	public void setIs_veg(String is_veg) {
		this.is_veg = is_veg;
	}
	@Override
	public String toString() {
		return "DataBean [id=" + id + ", status=" + status + ", race=" + race
				+ ", weight=" + weight + ", height=" + height + ", is_veg="
				+ is_veg + "]";
	}
	
	
}
