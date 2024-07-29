import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private List<Question> questions = new ArrayList<>();

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question){
        questions.add(question);
    }

    public int calculateScore(List<String> userAnswers){
        int score = 0;
        for(int i = 0 ; i < userAnswers.size() ; i++){
            if( userAnswers.get(i).equals(questions.get(i).getCorrectAnswer()))
            {
                score+=1;
            }
        }
        return score;
    }
}
