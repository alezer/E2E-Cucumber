package data;

public class WineData {
	String id;
	String name;
	String like;
	
	public WineData() {
		id = "cheval-noir";
		name = "Cheval Noir";
		like = "false";
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLike() {
		return like;
	}
	
	public void setLike(String value) {
		like = value;
	}
}