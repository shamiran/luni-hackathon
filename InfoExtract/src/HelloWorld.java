import java.io.IOException;
import java.util.ArrayList;

public class HelloWorld {
	public static void main(String[] args) throws IOException{
		String infile = "/home/jonis/git/luni-hackathon/exams/edan55/edan55-2013-10-25.pdf";
		String outfile = "histogram_eda16.txt";
		Exam exam = new Exam(infile);
		Histogram hist = new Histogram(exam);
		ArrayList<String> exercises = exam.parseExercises();
		TextfileConverter converter = new TextfileConverter(hist, outfile);
	}
}
