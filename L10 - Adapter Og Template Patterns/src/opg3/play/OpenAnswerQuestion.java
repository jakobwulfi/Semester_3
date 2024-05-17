package opg3.play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OpenAnswerQuestion extends Question {
    private String question;
    private String correctAnswer;

    public OpenAnswerQuestion(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }
    @Override
    protected void displayQuestion() {
        System.out.println("Open question: " + question);
    }

    @Override
    protected String getUserAnswer() {
        try {
            BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Dit svar: ");
            String answer = bfr.readLine();
            return answer;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected boolean checkAnswer(String answer) {
        return correctAnswer.toLowerCase().equals(answer.toLowerCase());
    }
}
