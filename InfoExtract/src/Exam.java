import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Exam {
	private String body;
	private String filepath;

	public Exam(String filepath) throws IOException{
        PDDocument doc = PDDocument.load(new File(filepath));
        body = new PDFTextStripper().getText(doc).toLowerCase();
		this.filepath = filepath;
	}
	
	public String getString(){
		return this.body;
	}
	
	private void stripBreaks(){
		this.body = this.body.replace("\n", " ").replace("\r", " ");
	}
	
	public ArrayList<String> parseExercises(){
		ArrayList<String> exercises = new ArrayList<String>();
		boolean break_loop = false;
		int start = body.indexOf("1" + ". ");
		int end;
		for(int i = 1; i < 10; i++){
			String index = "" + (i + 1) + ". ";
			end = body.indexOf(index);
			if(end == -1){
				end = body.length()-1;
				break_loop = true;
			}
			exercises.add(body.substring(start+3, end));
			start = end;	
			if(break_loop){
				break;
			}
		}
		return exercises;
	}
}
