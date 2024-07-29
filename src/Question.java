import java.util.List;

public class Question {

    private String text;
    private List<String> possibleAnswers;
    private String correctAnswer;

    public Question(String text, List<String> possibleAnswers, String correctAnswer){
        setText(text);
        setPossibleAnswers(possibleAnswers);
        setCorrectAnswer(correctAnswer);
    }

    public Question(String text, List<String> possibleAnswers, int correctAnswer){
        setText(text);
        setPossibleAnswers(possibleAnswers);
        setCorrectAnswer(possibleAnswers.get(correctAnswer));
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<String> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void display(){
        System.out.println("Question: " + getText());
        for (String s : getPossibleAnswers()) {
            System.out.println("Choice: " + s);
        }
    }
}
