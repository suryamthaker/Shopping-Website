
public class Manager {
	
	public String name;
	public int id;
	public String email;
	public String password;
	public String location;
	
	public Manager(String name, int id, String email, String password, String location) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.password = password;
		this.location = location;
	}
		
		
		public Manager() {
			super();
		}
		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}
		
		@Override
		public String toString() {
			return "User [name=" + name + ", id=" + id + ", email=" + email + ", password=" + password + ", location=" + location + "]";
		}
		
	
}
	


