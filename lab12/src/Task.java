import java.util.ArrayList;
import java.util.List;

public class Task {
    private String title;
    private List<String> answers = new ArrayList<String>();
    private String correctAnswer;

    public String getCorrectAnswer() {
        return correctAnswer;
    }


    public Task(String title, List<String> answers, String correctAnswer) {
        this.title = title;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }


    public String getTitle() {
        return title;
    }

    public List<String> getAnswers() {
        return answers;
    }
}