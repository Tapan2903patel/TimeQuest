import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quize_app {
//    public static final String "Already attempted the quize, not allowed further attempts." = "You already attemped the Quize, Cannot start the quiz.";
    private static int minutes = 10;
    private static int seconds = 0;
    private static Timer timer;
    private static int score = 0;
    private static final String CSV_FILE = "quiz_scores.csv";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Enrollment No:");
        long enr = sc.nextLong();
        sc.nextLine();  // Consume newline left-over

        if (hasEnrollmentRecord(String.valueOf(enr))) 
        {
            System.out.println("Already attempted the quize, not allowed further attempts.");
            return; // Exit the program
        }

        System.out.printf("Start the Quiz?\t\t\t(Time : %02d:%02d)\n\t1. Yes\n\t2. No\nPlease Enter the Choice:%n", minutes, seconds);

        int option = sc.nextInt();
        sc.nextLine();  // Consume newline left-over

        if (option == 1) {
            startQuiz(sc, enr);
        }
    }

    private static void startQuiz(Scanner sc, long enrollmentNo)
    {
        // Timer setup
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run()
            {
                if (seconds == 0)
                {
                    if (minutes == 0)
                    {
                        timer.cancel();
                        System.out.println("Time's up!");
                        System.out.println("Your final score is: " + score);

                        // Save the score to CSV if it's a new student
                        if (!hasEnrollmentRecord(String.valueOf(enrollmentNo)))
                        {
                            saveScore(String.valueOf(enrollmentNo), score); // Convert to String
                        }
                        else
                        {
                            System.out.println("Score not saved because the enrollment number already exists.");
                        }

                        System.exit(0);  // End the program
                    }
                    else
                    {
                        minutes--;
                        seconds = 59;
                    }
                }
                else
                {
                    seconds--;
                }
            }
        };

        // Schedule the task to run every second (1000 milliseconds)
        timer.scheduleAtFixedRate(task, 0, 1000);

        try {
            // Read all the lines from the Questions.txt
            List<String> lines = Files.readAllLines(Paths.get("Questions.txt"));
            int n = 0;

            while (n < lines.size()) {
                // Print the Remaining Time
                System.out.printf("\t\t\t\t\t\tTime left: %02d:%02d%n", minutes, seconds);

                // Print question and options
                for (int i = 0; i < 5 && n < lines.size(); i++) {
                    System.out.println(lines.get(n++));
                }

                // Get user's answer
                System.out.println("Select the Option:");
                String userAnswer = sc.nextLine();

                System.out.println();

                // Check the answer
                if (n < lines.size() && userAnswer.equalsIgnoreCase(lines.get(n).trim()))
                {
                    // If the Answer is Right then increase the Score
                    score++;
                }
                n++;  // Move to the next question block
            }

            // After attempting all the Questions, print the Final Score
            System.out.println("Quiz Completed Successfully!!!");
            System.out.println("Your Final Score is: " + score);

            // Save the score to CSV if it's a new student
            if (!hasEnrollmentRecord(String.valueOf(enrollmentNo)))
            {
                saveScore(String.valueOf(enrollmentNo), score); // Convert to String
            }
            else
            {
                System.out.println("Score not saved because You already attempted the quize.");
            }

        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static boolean hasEnrollmentRecord(String enrollmentNo)
    {
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(CSV_FILE));
            for (String line : lines)
            {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].equals(enrollmentNo))
                {
                    return true; // Enrollment number already exists
                }
            }
        }
        catch (IOException | NumberFormatException e)
        {
            System.out.println("Error checking CSV file: " + e.getMessage());
        }
        return false;
    }

    private static void saveScore(String enrollmentNo, int score)
    {
        try {
            // Use BufferedWriter for appending to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE, true));

            // Write the new student's record
            writer.write(enrollmentNo + "," + score + "\n");

            // Close the writer
            writer.close();

            System.out.println("Score saved successfully.");
        }
        catch (IOException e)
        {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}
