# TimeQuest

The " TimeQuest: Java-based Quiz Application with Score Tracking " project aims to develop a robust and interactive quiz application using Java programming language. This application allows users to participate in a timed quiz session where they can answer multiple-choice questions loaded from an external text file. Key features include a countdown timer, score calculation based on correct answers, and the capability to record and store quiz scores in a CSV file.

## Design Overview

### 1. Purpose and Functionality
"TimeQuest" is designed as a comprehensive quiz application implemented in Java, aimed at providing an engaging and interactive quiz experience. The primary functionalities of the application include:

**1. Quiz Initialization:** Users are prompted to enter their enrolment number to begin the quiz session.

**2. Timer Functionality:** A countdown timer starts from 10 minutes, indicating the remaining time for the quiz.

**3. Question Loading:** Multiple-choice questions are loaded dynamically from an external text file (Questions.txt), ensuring flexibility in quiz content.

**4. User Interaction:** Users select answers for each question through console input, with the application validating and recording their responses.

**5. Score Calculation:** The application calculates and updates the user's score based on correct answers during the quiz session.

**6. Score Recording:** Upon completing the quiz or when the timer expires, the user's enrolment number and final score are recorded in a CSV file (quiz_scores.csv).

### 2. Key Features

**1. Countdown Timer:** Implemented using Java's Timer and TimerTask classes, ensuring accurate timekeeping and countdown functionality.

**2. File Handling:** Utilizes Java's Files and Paths classes to read questions from Questions.txt and manage score recording in quiz_scores.csv.

**3. User Interface:** Utilizes console-based interaction for simplicity and ease of use, with clear prompts and feedback during the quiz session.

**4. Error Handling:** Implements robust error handling mechanisms to manage file IO errors, user input validation, and unexpected scenarios during quiz execution.

## Future Improvements
While "TimeQuest" functions effectively as a basic quiz application, several areas can be enhanced to improve functionality, user experience, and maintainability:

**1.	Enhanced User Interface:** Implement a graphical user interface (GUI) using JavaFX or Swing to provide a more intuitive and visually appealing quiz experience.

**2.	Database Integration:** Replace CSV file storage with a relational database (e.g., MySQL, PostgreSQL) to manage user data, quiz questions, and scores more efficiently.

**3.	User Management:** Introduce user authentication and profile management features, allowing users to create accounts, track their quiz history, and view past scores.

**4.	Advanced Quiz Features:** Include support for different question types (e.g., true/false, fill-in-the-blank) and randomization of question order to enhance quiz variability.

**5.	Feedback and Analytics:** Incorporate feedback mechanisms for users to provide input on quiz questions and performance analytics to analyze quiz results comprehensively.

**6.	Localization and Internationalization:** Support multiple languages and localization features to cater to a global audience, enhancing accessibility and usability.

**7.	Security Enhancements:** Implement secure coding practices and data encryption techniques to protect user information and ensure data integrity.

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

