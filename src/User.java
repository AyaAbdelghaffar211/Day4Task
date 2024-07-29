import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private List<String> answers = new ArrayList<>();

    public User(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public void recordAnswer(String answer){
        answers.add(answer);
    }

    public int progress(int noOfQuizQuestions){
        return (int)((answers.size()/(double)noOfQuizQuestions)*100);
    }
}
