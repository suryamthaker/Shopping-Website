import java.io.FileWriter;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainStore {

public ArrayList<Store> stores = new ArrayList<Store>();
	
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Store store = new Store();
			//name,id,email,password
			store.setLocation(reader.get("location"));
			store.setOpeningHours(reader.get("Opening Hours"));
			store.setClosingHours(reader.get("Closing Hours"));
			stores.add(store);
		}
	}
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("location");
				csvOutput.write("Opening Hours");
		    	csvOutput.write("Closing Hours");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(Store a: stores){
					csvOutput.write(a.getLocation());
					csvOutput.write(a.getOpeningHours());
					csvOutput.write(a.getClosingHours());
					
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public static void main(String [] args) throws Exception{
		String path = "/Users/suryam/Desktop/store.csv";
		MaintainUser maintain = new MaintainUser();
	
		maintain.load(path);
		for(User u: maintain.users){
			System.out.println(u.toString());
		}
		
		
		
	
		
		maintain.update(path);
	}
	
	
}
