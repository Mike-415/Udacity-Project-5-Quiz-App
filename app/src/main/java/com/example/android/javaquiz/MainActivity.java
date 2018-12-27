package com.example.android.javaquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.question1_correct_radio_button)
    RadioButton question1CorrectRadioButton;
    @BindView(R.id.question2_correct_checkbox1)
    CheckBox question2CorrectCheckbox1;
    @BindView(R.id.question2_correct_checkbox2)
    CheckBox question2CorrectCheckbox2;
    @BindView(R.id.question2_incorrect_checkbox1)
    CheckBox question2IncorrectCheckbox1;
    @BindView(R.id.question2_correct_checkbox3)
    CheckBox question2CorrectCheckbox3;
    @BindView(R.id.question2_incorrect_checkbox2)
    CheckBox question2IncorrectCheckbox2;
    @BindView(R.id.question2_incorrect_checkbox3)
    CheckBox question2IncorrectCheckbox3;
    @BindView(R.id.question3_edit_text)
    EditText question3EditText;
    @BindView(R.id.question4_incorrect_checkbox1)
    CheckBox question4IncorrectCheckbox1;
    @BindView(R.id.question4_correct_checkbox1)
    CheckBox question4CorrectCheckbox1;
    @BindView(R.id.question4_incorrect_checkbox2)
    CheckBox question4IncorrectCheckbox2;
    @BindView(R.id.question4_incorrect_checkbox3)
    CheckBox question4IncorrectCheckbox3;
    @BindView(R.id.question4_correct_checkbox2)
    CheckBox question4CorrectCheckbox2;
    @BindView(R.id.question4_correct_checkbox3)
    CheckBox question4CorrectCheckbox3;
    @BindView(R.id.question5_correct_radio_button)
    RadioButton question5CorrectRadioButton;

    /**
     * Calculate the total score of all of the quiz questions
     *
     * @return the total score of all questions
     */
    private int calculateScore() {
        int totalScore = 0;
        totalScore += calculateQuestion1Score();
        totalScore += calculateQuestion2Score();
        totalScore += calculateQuestion3Score();
        totalScore += calculateQuestion4Score();
        totalScore += calculateQuestion5Score();
        return totalScore;
    }

    /**
     * Calculate the points based off of the RadioButton choosen for question 1
     *
     * @return points for question 1
     */
    private int calculateQuestion1Score() {
        return question1CorrectRadioButton.isChecked() ? 20 : 0;
    }

    /**
     * Calculate the points based on the CheckBoxes checked for question 2
     *
     * @return points for question 2
     */
    private int calculateQuestion2Score() {
        boolean allCorrectCheckBoxesChecked = question2CorrectCheckbox1.isChecked() && question2CorrectCheckbox2.isChecked() && question2CorrectCheckbox3.isChecked();
        boolean allIncorrectCheckBoxesNotChecked = !question2IncorrectCheckbox1.isChecked() && !question2IncorrectCheckbox2.isChecked() && !question2IncorrectCheckbox3.isChecked();
        return (allCorrectCheckBoxesChecked && allIncorrectCheckBoxesNotChecked) ? 20 : 0;
    }

    /**
     * Calculate the points based on the EditText answer of question 3
     *
     * @return points for question 3
     */
    private int calculateQuestion3Score() {
        String answer = question3EditText.getText().toString().trim();
        return (answer.equals("(Cat)")) ? 20 : 0;
    }

    /**
     *  Calculate the points based on the CheckBoxes checked for question 4
     *
     * @return points for question 4
     */
    private int calculateQuestion4Score() {
        boolean allCorrectCheckBoxesChecked = question4CorrectCheckbox1.isChecked() && question4CorrectCheckbox2.isChecked() && question4CorrectCheckbox3.isChecked();
        boolean allIncorrectCheckBoxesNotChecked = !question4IncorrectCheckbox1.isChecked() && !question4IncorrectCheckbox2.isChecked() && !question4IncorrectCheckbox3.isChecked();
        return (allCorrectCheckBoxesChecked && allIncorrectCheckBoxesNotChecked) ? 20 : 0;
    }

    /**
     * Calculate the points based off of the RadioButton choosen for question 5
     *
     * @return points for question 5
     */
    private int calculateQuestion5Score() {
        return question5CorrectRadioButton.isChecked() ? 20 : 0;
    }


    /**
     * Calculate grade based on the score
     *
     * @param score is the total score
     * @return a formatted string
     */
    private String getGradeText(int score) {
        if (score > 50) {
            return "You passed with a grade of " + score + "%";
        } else {
            return "You failed with a grade of " + score + "%";
        }
    }

    @OnClick(R.id.submit_button)
    public void onSubmitClicked() {
        int score = calculateScore();
        Toast.makeText(getApplicationContext(), getGradeText(score), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }
}
