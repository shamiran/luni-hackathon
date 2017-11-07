public class HelloWorld {
	public static void main(String[] args) {
		String infile = "PDF/EDA16";
		String outfile = "data/histogram_eda16.txt";
		Exam exam = new Exam(infile);
		Histogram hist = new Histogram(exam);
		TextFileConverter converter = new TextFileConverter(hist, outfile);
	}
}
