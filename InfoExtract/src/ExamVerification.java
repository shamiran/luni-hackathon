import java.util.regex.*;

/**
 * Class to verify if a pdf (string) is an exam.
 * Needs to create object and then run verify.
 * 
 * @author anton
 *
 */
public class ExamVerification {
	String exam;
	
	ExamVerification(String exam) {
		this.exam = exam;
	}
	
	/**
	 * @return course code if an exam, otherwise an empty string.
	 */
	public String verify() {
		Pattern pat = Pattern.compile(".*exam.*");
		Matcher mat = pat.matcher(exam);

		if(!mat.find()) {
			return "-1";
		}
		
		pat = Pattern.compile("[a-z][a-z][a-z][a-z0-9][0-9][0-9]");
		mat = pat.matcher(exam);

		if(!mat.find()) {
			return "";
		}
		
		return mat.group();
	}
}
