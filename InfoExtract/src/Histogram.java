import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Histogram {

	private Map<String, Integer> histogram;
	
	public Histogram(String exams){
		histogram = new TreeMap<String, Integer>();
		readExams(exams);
	}
	
	public Map<String, Integer> getMap(){
		return histogram;
	}
	
	private void readExams(String exams){
		String feed = exams.toLowerCase();
		String[] wordList = feed.split(" ");
		for(String word: wordList){
			
			if(word.length() > 5 && word.matches("^[a-z]+$")){
				int n = histogram.getOrDefault(word, 0); // Kollar v�rdet f�r word, s�tter detta
													// till n. Om word inte finns s�tts n
													// till 0
				n++;
				histogram.put(word, n);
			}
		}
	}
}

