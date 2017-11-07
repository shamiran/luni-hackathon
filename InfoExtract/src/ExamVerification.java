import java.util.regex.*;
public class ExamVerification {
	String exam;
	
	ExamVerification(String exam) {
		this.exam = exam;
	}
	
	public boolean verify() {
		Pattern pat = Pattern.compile(".*[a-z][a-z][a-z][a-z0-9][0-9][0-9].*");
		Matcher mat = pat.matcher(exam);

		if(!mat.matches()) {
			return false;
		}
		
		pat = Pattern.compile(".*exam.*");
		mat = pat.matcher(exam);

		if(!mat.matches()) {
			return false;
		}
		
		return true;
	}
}
