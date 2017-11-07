import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HelloWorld {
	public static void main(String[] args) throws IOException{
		String outfile = "histogram_eda16.txt";

        ArrayList<String> fileNames = new PathExtractor("/home/jonis/git/luni-hackathon/exams/edan55").getExams();
        StringBuilder sb = new StringBuilder();
        for (String s : fileNames) {
            sb.append(new PDFParser(new File(s)));
        }
        String exams = sb.toString();
		Histogram hist = new Histogram(exams);
		new TextfileConverter(hist, outfile);
	}
}