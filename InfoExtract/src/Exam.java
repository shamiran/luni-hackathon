import java.util.ArrayList;


public class Exam {
	private String body;
	private String filepath;

	public Exam(String filepath){
		this.filepath = filepath;
		this.body = "1. Show that the process, 1 t e−cs dWs ,where c is a positive constant and where Wt is a standard Brownian motion, is a martingale for X(t) = exp −4c(1 − e−2ct) 2. Your bank offers you a derivative called a iron condor. The derivative has maturity T and the t ≥ 0.";
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
