import java.io.FileWriter;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainItem {
	
public ArrayList<Item> items = new ArrayList<Item>();
	
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Item item = new Item();
			//name,id,email,password
			item.setName(reader.get("name"));
			item.setLocation(reader.get("location"));
			item.setDescription(reader.get("description"));
			item.setCategory(reader.get("category"));
			item.setPrice(Double.valueOf(reader.get("price")));
			item.setSize(Double.valueOf(reader.get("size")));
			item.setAvailability(Integer.valueOf(reader.get("availability")));
			item.setOnSale(Boolean.valueOf(reader.get("onSale")));
			item.setFrequency(Integer.valueOf(reader.get("frequency")));
			
		
			items.add(item);
			
		}
	}
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("name");
				csvOutput.write("location");
				csvOutput.write("description");
		    	csvOutput.write("category");
				csvOutput.write("price");
				csvOutput.write("size");
				csvOutput.write("availability");
				csvOutput.write("onSale");
				csvOutput.write("frequency");
				
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(Item a: items){
					csvOutput.write(a.getName());
					csvOutput.write(a.getLocation());
					csvOutput.write(a.getDescription());
					csvOutput.write(a.getCategory());
					csvOutput.write(String.valueOf(a.getPrice()));
					csvOutput.write(String.valueOf(a.getSize()));
					csvOutput.write(String.valueOf(a.getAvailability()));
					csvOutput.write(String.valueOf(a.getOnSale()));
					csvOutput.write(String.valueOf(a.getFrequency()));
					
					
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public static void main(String [] args) throws Exception{
		String path = "/Users/suryam/Desktop/item.csv";
		MaintainUser maintain = new MaintainUser();
		
	
		maintain.load(path);
		for(User u: maintain.users){
			System.out.println(u.toString());
		}
		
		maintain.update(path);
	}

}
