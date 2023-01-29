import java.io.FileWriter;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainAdmin {
	
public ArrayList<Admin> admins = new ArrayList<Admin>();
	
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Admin user = new Admin();
			//name,id,email,password
			user.setName(reader.get("name"));
			user.setId(Integer.valueOf(reader.get("id")));
			user.setEmail(reader.get("email"));
			user.setPassword(reader.get("password"));
			admins.add(user);
			
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
				
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(Admin a: admins){
					csvOutput.write(a.getName());
					csvOutput.write(String.valueOf(a.getId()));
					csvOutput.write(a.getEmail());
					csvOutput.write(a.getPassword());
					
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public static void main(String [] args) throws Exception{
		String path = "/Users/suryam/Desktop/admin.csv";
		MaintainUser maintain = new MaintainUser();
		
	
		maintain.load(path);
		for(User u: maintain.users){
			System.out.println(u.toString());
		}
		
		
		
	
		
		maintain.update(path);
	}

}
