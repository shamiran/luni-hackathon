public class HelloWorld {
	public static void main(String[] args) {
		//filepath = "PDF/EDA16";
		Exam exam = new Exam(filepath);
		Histogram hist = new Histogram(exam);
		TextFileConverter converter = new TextFileConverter(hist);
	}
}
