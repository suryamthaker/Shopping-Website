
public class Item {
	public String name;
	public String location;
	public String description;
	public String category;
	public double price;
	public double size;
	public int availability; 
	public boolean onSale;
	public int frequency;
	
	
	
	public Item(String name, String location, String description, String category, double price, double size, int availability, boolean onSale, int frequency) {
		super();
		this.name = name;
		this.location = location;
		this.availability = availability;
		this.category = category;
		this.description = description;
		this.price = price;
		this.size = size;
		this.onSale = onSale;
		this.frequency = frequency;
		
		
	}
	
	public Item() {
		super();
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getAvailability() {
		return availability;
	}
	
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getSize() {
		return size;
	}
	
	public void setSize(double size) {
		this.size = size;
	}
	
	public boolean getOnSale() {
		return onSale;
	}
	
	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	
	

}
