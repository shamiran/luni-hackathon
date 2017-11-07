
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
}
