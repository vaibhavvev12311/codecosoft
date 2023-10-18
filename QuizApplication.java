import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static String[] questions = {
        "What is 2 + 2?",
        "What is the capital of France?",
        "Which planet is known as the Red Planet?"
    };
    
    private static String[] options = {
        "a) 3  b) 4  c) 5  d) 6",
        "a) London  b) Berlin  c) Paris  d) Madrid",
        "a) Venus  b) Earth  c) Mars  d) Jupiter"
    };
    
    private static char[] answers = {'b', 'c', 'c'};
    
    private static int currentQuestion = 0;
    private static int score = 0;
    private static int timeLeft = 25;
    private static Timer timer = new Timer();
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz!");
        displayQuestion();
    }
    
    private static void displayQuestion() {
        if (currentQuestion < questions.length) {
            System.out.println(questions[currentQuestion]);
            System.out.println(options[currentQuestion]);
            startTimer();
            getAnswer();
        } else {
            showResult();
        }
    }
    
    private static void startTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time Left: " + timeLeft + " seconds");
                if (timeLeft == 0) {
                    timer.cancel();
                    getAnswer();
                }
                timeLeft--;
            }
        }, 1000, 1000);
    }
    
    private static void getAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        char userAnswer = scanner.next().toLowerCase().charAt(0);
        if (userAnswer == answers[currentQuestion]) {
            score++;
            System.out.println("Correct!\n");
        } else {
            System.out.println("Incorrect!\n");
        }
        currentQuestion++;
        timeLeft = 25;
        displayQuestion();
    }
    
    private static void showResult() {
        System.out.println("Quiz Finished!");
        System.out.println("Your Score: " + score + " out of " + questions.length);
    }
}
