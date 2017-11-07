import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TextfileConverter {

	TextfileConverter(Histogram hist, String filename) {
		
		Map<String,Integer> hm = hist.getMap();
		
		String str = iterateMap(hm);
		
		writeFile(filename,str);
		
	}
	
	private String iterateMap(Map<String,Integer> hm) {
		String str = "";
		
		for (Entry<String, Integer> entry : hm.entrySet()) {
		    str = str + entry.getKey() + ";" + entry.getValue() + "\n";
		}
		
		return str;
	}
	
	private void writeFile(String filename, String data) {
		try {
			  FileWriter fstream = new FileWriter(filename);
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write(data);

			  out.close();

		} catch (Exception e) {
			  System.err.println("Error: " + e.getMessage());
		}
	}
	
}
