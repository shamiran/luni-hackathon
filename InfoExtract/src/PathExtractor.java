import java.io.File;
import java.util.ArrayList;

public class PathExtractor {

    private ArrayList<String> exams;

    public PathExtractor(String dir) {
        ArrayList<String> exams = new ArrayList<>();
        File folder = new File(dir);
        for (File exam : folder.listFiles()) {
            exams.add(exam.getAbsolutePath());
        }
        this.exams = exams;
    }

    public ArrayList<String> getExams() {
        return exams;
    }
}
