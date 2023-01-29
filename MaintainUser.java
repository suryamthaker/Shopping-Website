
import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainUser {
	public ArrayList<User> users = new ArrayList<User>();
	
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			User user = new User();
			//name,id,email,password
			user.setName(reader.get("name"));
			user.setId(Integer.valueOf(reader.get("id")));
			user.setEmail(reader.get("email"));
			user.setPassword(reader.get("password"));
			user.setLocation(reader.get("location"));
			user.setQuestion(reader.get("question"));
			user.setAnswer(reader.get("answer"));
			user.setPath(reader.get("path"));
			users.add(user);
		}
	}
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("name");
				csvOutput.write("id");
		    	csvOutput.write("email");
				csvOutput.write("password");
				csvOutput.write("location");
				csvOutput.write("question");
				csvOutput.write("answer");
				csvOutput.write("path");
			
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few record
				for(User u: users){
					csvOutput.write(u.getName());
					csvOutput.write(String.valueOf(u.getId()));
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPassword());
					csvOutput.write(u.getLocation());
					csvOutput.write(u.getQuestion());
					csvOutput.write(u.getAnswer());
					csvOutput.write(u.getPath());
					
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public static void main(String [] args) throws Exception{
		String path = "/Users/suryam/Desktop/user.csv";
		MaintainUser maintain = new MaintainUser();
		
	
		maintain.load(path);
		for(User u: maintain.users){
			System.out.println(u.toString());
		}
		
		
		
	
		
		maintain.update(path);
	}
}
