import java.util.ArrayList;
import java.util.HashMap;

public class Histogram {
	private HashMap<String, Integer> histogram;
	
	
	public Histogram(Exam exam){
		histogram = new HashMap<String, Integer>();
		readExam(exam);	
	}
	
	public HashMap<String, Integer> getMap(){
		return histogram;
	}
	
	private void readExam(Exam exam){
		String[] listOfExams = exam.getString().split(" ");
		for(String word: listOfExams){
			
			
			int n = histogram.getOrDefault(word, 0); // Kollar v�rdet f�r word, s�tter detta
												// till n. Om word inte finns s�tts n
												// till 0
			n++;
			histogram.put(word, n);
		}
	}
	
}

