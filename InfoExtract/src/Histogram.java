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
		String string = exam.getString();
		string.toLowerCase();
		
		string.replace(".","");
		string.replace(",","");
		string.replace("!","");
		string.replace("?","");
		string.replace("0","");
		string.replace("1","");
		string.replace("2","");
		string.replace("3","");
		string.replace("4","");
		string.replace("5","");
		string.replace("6","");
		string.replace("7","");
		string.replace("8","");
		string.replace("9","");
		string.replace("0","");
		string.replace(":","");
		string.replace(";","");
		string.replace("+","");
		string.replace("-","");
		string.replace("a)","");
		string.replace("b)","");
		string.replace("c)","");
		string.replace("d)","");
		string.replace("e)","");
		string.replace("f)","");
		string.replace("(","");
		string.replace(")","");
		
		
		String[] listOfExams = string.split(" ");
		for(String word: listOfExams){
			
			
			int n = histogram.getOrDefault(word, 0); // Kollar värdet för word, sätter detta
												// till n. Om word inte finns sätts n
												// till 0
			n++;
			histogram.put(word, n);
		}
	}
	
}

