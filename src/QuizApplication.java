import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuizApplication {

    private User user;
    private List<Question> questionBank = new ArrayList<>();
    private Quiz quiz;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Question> getQuestionBank() {
        return questionBank;
    }

    public void setQuestionBank(List<Question> questionBank) {
        this.questionBank = questionBank;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }


    public void registerUser(String name){
        user = new User(name);
    }

    public void createQuiz(int noOfQuestions){
        quiz = new Quiz();
        for(int i = 0; i < noOfQuestions ; i++){
            quiz.addQuestion(questionBank.get(new Random().nextInt(questionBank.size())));
        }
    }

    public void displayQuiz(){
        Scanner sc = new Scanner(System.in);
        for(Question q: quiz.getQuestions()) {
            q.display();
            System.out.println("Enter your answer in the form of a text or a number from 1 to 4");
            String response = sc.nextLine();
            try {
                int responseInt = Integer.parseInt(response);
                user.getAnswers().add(q.getPossibleAnswers().get(responseInt - 1));
            } catch (NumberFormatException e1) {
                user.getAnswers().add(response);
            }
            System.out.println("Progress: " + progress() + "%");
        }
    }

    public int progress(){
        return user.progress(quiz.getQuestions().size());
    }

    public double calculateScore(){
        return quiz.calculateScore(user.getAnswers());
    }

    public void addQuestion(Question newQuestion){
        questionBank.add(newQuestion);
    }

    public void displayAddQuestion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter question: ");
        String questionText = sc.nextLine();
        List<String> questionChoices = new ArrayList<>();
        while(true){
            System.out.println("Enter choice: ");
            questionChoices.add(sc.nextLine());
            System.out.println("Press f to finish or any other key to enter another choice");
            String contOrFinish = sc.nextLine();
            if (!contOrFinish.isEmpty() && contOrFinish.charAt(0) == 'f') {
                break;
            }
        }
        System.out.println("Please enter correct answer: ");
        String questionCorrectAnswer = sc.nextLine();

        questionBank.add(new Question(questionText,questionChoices,questionCorrectAnswer));
    }
}
