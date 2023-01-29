

public class Store {
	public String location;
	public String openingHours;
	public String closingHours;
	
	
	
	public Store(String location, String openingHours, String closingHours) {
		super();
		this.location = location;
		this.openingHours = openingHours;
		this.closingHours = closingHours;
		
	
	}
	
	public Store() {
		super();
	}
	
	public String getLocation() {
		return location;
		
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	

	
	
	public String getClosingHours() {
		return closingHours;
		
	}
	
	public void setClosingHours(String closingHours) {
		this.closingHours = closingHours;
	}
	

	public String getOpeningHours() {
		return openingHours;
		
	}
	
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	
	

}
