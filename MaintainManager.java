import java.io.FileWriter;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainManager {

public ArrayList<Manager> managers = new ArrayList<Manager>();
	
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Manager user = new Manager();
			//name,id,email,password
			user.setName(reader.get("name"));
			user.setId(Integer.valueOf(reader.get("id")));
			user.setEmail(reader.get("email"));
			user.setPassword(reader.get("password"));
			user.setLocation(reader.get("location"));
			
			managers.add(user);
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
				
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(Manager m: managers){
					csvOutput.write(m.getName());
					csvOutput.write(String.valueOf(m.getId()));
					csvOutput.write(m.getEmail());
					csvOutput.write(m.getPassword());
					csvOutput.write(m.getLocation());
					
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public static void main(String [] args) throws Exception{
		String path = "/Users/suryam/Desktop/manager.csv";
		MaintainManager maintain = new MaintainManager();
		
	
		maintain.load(path);
		for(Manager u: maintain.managers){
			System.out.println(u.toString());
		}
		
		
		
	
		
		maintain.update(path);
	}
	
}
