import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        QuizApplication quizApp = new QuizApplication();
        quizApp.addQuestion(new Question("What is the capital of Japan?", Arrays.asList("Tokyo", "Kyoto", "Osaka", "Hiroshima"), 0));
        quizApp.addQuestion(new Question("Which planet is known as the Red Planet?", Arrays.asList("Mars", "Venus", "Earth", "Jupiter"), "Mars"));
        quizApp.addQuestion(new Question("What is the chemical symbol for gold?", Arrays.asList("Au", "Ag", "Pb", "Fe"), 0));
        quizApp.addQuestion(new Question("Who wrote 'To Kill a Mockingbird'?", Arrays.asList("Harper Lee", "Mark Twain", "J.K. Rowling", "Ernest Hemingway"), 1));
        quizApp.addQuestion(new Question("Which element is essential for breathing?", Arrays.asList("Oxygen", "Hydrogen", "Carbon", "Nitrogen"), "Oxygen"));
        quizApp.addQuestion(new Question("What is the largest mammal in the world?", Arrays.asList("Blue Whale", "Elephant", "Giraffe", "Shark"), 0));
        quizApp.addQuestion(new Question("What is the hardest natural substance on Earth?", Arrays.asList("Diamond", "Gold", "Iron", "Platinum"), 3));
        quizApp.addQuestion(new Question("Which country is known as the Land of the Rising Sun?", Arrays.asList("Japan", "China", "India", "South Korea"), 0));
        quizApp.addQuestion(new Question("What year did the Titanic sink?", Arrays.asList("1912", "1905", "1898", "1923"), "1912"));
        quizApp.addQuestion(new Question("Which ocean is the largest?", Arrays.asList("Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean"),"Pacific Ocean"));

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Welcome to quizBot!\nPlease enter \"a\" to proceed as admin" +
                    " and add questions to the bank or \"s\" to proceed as a student to " +
                    "take a quiz");
            String adminOrStudent = sc.next();
            if (!adminOrStudent.isEmpty()) {
                if(adminOrStudent.charAt(0) == 'a'){
                    while(true){
                        quizApp.displayAddQuestion();
                        System.out.println("Enter another question? y/n");
                        String anotherQuestion = sc.next();
                        if(!anotherQuestion.isEmpty() && anotherQuestion.charAt(0) == 'n') {
                            break;
                        }
                    }
                }else if(adminOrStudent.charAt(0) == 's'){
                    System.out.println("Please enter your name");
                    quizApp.registerUser(sc.next());
                    System.out.println("Please enter number of questions you want in the quiz: ");
                    int noOfQuizQuestions = sc.nextInt();
                    quizApp.createQuiz(noOfQuizQuestions);
                    quizApp.displayQuiz();
                    System.out.println("Total score: " + quizApp.calculateScore());
                }else{
                    System.out.println("Please enter a valid character");
                }
            }
        }
    }
}