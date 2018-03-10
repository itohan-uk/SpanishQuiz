package com.example.android.spanishquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String correct = "Correct";
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitButton(View view) {
        String firstAnswer = question1Listener();
        String secondAnswer = question2Listener();
        String thirdAnswer = question3Listener();
        String fourthAnswer = question4Listener();
        String fifthAnswer = question5Listener();
        String sixthAnswer = question6Listener();
        String finalScore = String.format("%.2f", ((score / 6.0) * 100));
        String toastMsg = firstAnswer + "\n" + secondAnswer + "\n"
                + thirdAnswer + "\n" + fourthAnswer + "\n" + fifthAnswer +
                "\n" + sixthAnswer + "\n" + "Your Score is: " + finalScore;

        for (int i = 0; i < 2; i++) {
            Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
        }
        score = 0;

    }

    private String question1Listener() {
        int answer_1 = R.id.q1b;
        RadioGroup radio1 = findViewById(R.id.q1_radio);
        int selectedButton = radio1.getCheckedRadioButtonId();
        if (answer_1 == selectedButton) {
            score += 1;
            return "1. " + correct;
        }
        return "1. Wrong!!! Correct answer is: " + ((RadioButton)
                findViewById(answer_1)).getText();
    }

    private String question2Listener() {
        Boolean a = ((CheckBox) findViewById(R.id.q2a)).isChecked();
        Boolean b = ((CheckBox) findViewById(R.id.q2b)).isChecked();
        Boolean c = ((CheckBox) findViewById(R.id.q2c)).isChecked();
        Boolean d = ((CheckBox) findViewById(R.id.q2d)).isChecked();


        if (b && d && !a && !c) {
            score += 1;
            return "2. " + correct;
        }
        return "2. Wrong!!! Correct answer is: " + ((CheckBox)
                findViewById(R.id.q2b)).getText() + " and " +
                ((CheckBox) findViewById(R.id.q2d)).getText();
    }

    private String question3Listener() {
        String writtenAnswer = (((EditText) findViewById(R.id.q3_box)).getText())
                .toString();
        String correctAnswer = "iwritebooks";

        if (correctAnswer.equalsIgnoreCase((writtenAnswer.replace(" ", "")))) {
            score += 1;
            return "3. " + correct;
        }
        return "3. Wrong!!! Correct answer is \"I write books\"";
    }

    private String question4Listener() {
        String writtenAnswer = (((EditText) findViewById(R.id.q4_box)).getText())
                .toString();
        String correctAnswer = "denada";

        if (correctAnswer.equalsIgnoreCase(writtenAnswer.replace(" ", ""))) {
            score += 1;
            return "4. " + correct;
        }
        return "4. Wrong!!! Correct answer is \"De nada\"";
    }

    private String question5Listener() {
        Boolean a = ((CheckBox) findViewById(R.id.q5a)).isChecked();
        Boolean b = ((CheckBox) findViewById(R.id.q5b)).isChecked();
        Boolean c = ((CheckBox) findViewById(R.id.q5c)).isChecked();
        Boolean d = ((CheckBox) findViewById(R.id.q5d)).isChecked();


        if (a && c && !b && !d) {
            score += 1;
            return "5. " + correct;
        }
        return "5. Wrong!!! Correct answer is: " + ((CheckBox)
                findViewById(R.id.q5a)).getText() + " and " +
                ((CheckBox) findViewById(R.id.q5c)).getText();

    }

    private String question6Listener() {
        int answer_6 = R.id.q6c;
        RadioGroup radio6 = findViewById(R.id.q6_radio);
        int selectedButton = radio6.getCheckedRadioButtonId();
        if (answer_6 == selectedButton) {
            score += 1;
            return "6. " + correct;
        }
        return "6. Wrong!!! Correct answer is: " + ((RadioButton)
                findViewById(answer_6)).getText();
    }

}
