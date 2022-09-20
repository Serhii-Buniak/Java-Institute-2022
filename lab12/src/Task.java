import java.util.ArrayList;
import java.util.List;

public class Task {
    private String title;
    private List<TaskAnswer> answers = new ArrayList<TaskAnswer>();
    private int correctAnswerId;

    public Task(String title, List<TaskAnswer> answers, int correctAnswerId) {
        this.title = title;
        this.answers = answers;
        this.correctAnswerId = correctAnswerId;
    }

    public String getTitle() {
        return title;
    }

    public List<TaskAnswer> getAnswers() {
        return answers;
    }

    public int getCorrectAnswerId() {
        return correctAnswerId;
    }
}