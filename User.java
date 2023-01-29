import java.util.ArrayList;

public class User {
	public String name;
	public int id;
	public String email;
	public String password;
	public String location;
	public String question;
	public String answer;
	public String path;
	
	
	
	public User(String name, int id, String email, String password, String location, String question, String answer, String path) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.password = password;
		this.location = location;
		this.question = question;
		this.answer = answer;
	    this.path = path;
	
		
	}
	
	public User(){
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
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", email=" + email + ", password=" + password + ", location=" + location + ", question=" + question + ", answer=" + answer + "]";
	}
	
}
