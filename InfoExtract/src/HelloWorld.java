import java.util.ArrayList;

public class HelloWorld {
	public static void main(String[] args) {
		String infile = "PDF/EDA16";
		String outfile = "data/histogram_eda16.txt";
		Exam exam = new Exam(infile);
//		Histogram hist = new Histogram(exam);
		ArrayList<String> exercises = exam.parseExercises();
		System.out.println(exercises.get(1));
//		TextfileConverter converter = new TextfileConverter(hist, outfile);
	}
}