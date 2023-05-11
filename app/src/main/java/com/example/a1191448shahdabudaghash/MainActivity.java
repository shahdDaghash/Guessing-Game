package com.example.a1191448shahdabudaghash;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // define global variables
    EditText passwordText;
    Switch writeSwitch;
    TextView inputText;
    TextView scoreText;
    TextView attemptsText;
    TextView outputText;
    Button button1;
    Button button2;

    // define and initialize score and # of attempts
    int score = 0;
    int attempts = 3;

    // when user2 enters an incorrect letter, the game will prevent them from adding a new letter until they delete the wrong letter
    boolean worngLetterEntered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define password edit text
        passwordText = findViewById(R.id.editTextPassword);
        passwordText.setKeyListener(null); // prevent edit text from getting filled by keyboard

        // define input textView
        inputText = findViewById(R.id.inputText);

        // define switch
        writeSwitch = findViewById(R.id.writeSwitch);
        writeSwitch.setChecked(true); //initialize to enabled to write password

        // define buttons array
        Button [] letterButtons = {
            findViewById(R.id.keyButtonQ), findViewById(R.id.keyButtonW),
            findViewById(R.id.keyButtonE), findViewById(R.id.keyButtonR),
            findViewById(R.id.keyButtonT), findViewById(R.id.keyButtonY),
            findViewById(R.id.keyButtonU), findViewById(R.id.keyButtonL),
            findViewById(R.id.keyButtonA), findViewById(R.id.keyButtonS),
            findViewById(R.id.keyButtonB), findViewById(R.id.keyButtonJ)
        };

        // set up functionality of letter buttons
        for(Button button: letterButtons){
            setupButton(button);
        }

        //define and set functionality for space button
        Button buttonSpace = findViewById(R.id.keyButtonSpace);
        setupButton(buttonSpace);


        // define and set functionality for delete button
        Button buttonDelete = findViewById(R.id.keyButtonDelete);
        buttonDelete.setOnClickListener(view -> {
            if(writeSwitch.isChecked()){ //deleting done on password text
                int length = passwordText.getText().length();
                if(length > 0){ // delete text if > 0
                    passwordText.getText().delete(length - 1, length); // this deletes the last char
                }
            }
            // don't delete if user2 guesses correctly and game success
            else if(!inputText.getText().toString().equals(passwordText.getText().toString())){ // deleting done on textView
                int length = inputText.getText().length();
                if(length > 0){ // delete text if > 0
                    String password = passwordText.getText().toString();
                    int index = inputText.getText().length()-1;
                    if(inputText.getText().toString().charAt(index) == password.charAt(index)){ // if the deleted character was correct
                        score--; // remove char score
                        scoreText.setText("Score: " + score);
                    }
                    // take only char up to the second to last -> removes last char
                    inputText.setText(inputText.getText().subSequence(0, length - 1));
                    worngLetterEntered = false;
                }
            }

        });

        // setup button 1 and button 2
        button1 = findViewById(R.id.keyButton1);
        button2 = findViewById(R.id.keyButton2);

        button2.setEnabled(false); // disable button 2 in the

        // set on click listener for button1
        button1.setOnClickListener(view -> {
            if(!passwordText.getText().toString().isEmpty()){ // if password is not empty
                passwordText.setEnabled(false);
                button1.setEnabled(false);
            }
            else{ // display a toast if the password is empty
                Toast toast =Toast.makeText(MainActivity.this, "Password can not be empty",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        // set on click listener for button2
        button2.setOnClickListener(view -> restartApp());

        // define view texts
        scoreText = findViewById(R.id.scoreText);
        attemptsText = findViewById(R.id.attemptsText);
        outputText = findViewById(R.id.outputText);

    }

    //Set up what is needed from the letter button
    public void setupButton(Button button){
        // use button texts for adding letter, and substitute " " instead of "Space" for the space button
        final String buttonText = (button.getText().toString().equals("Space"))? " ": button.getText().toString();

        // set up on click listener for clicked button
        button.setOnClickListener(view -> {
            //writing done on password text only if switch is checked and user1 mode
            if(writeSwitch.isChecked() && button1.isEnabled() && passwordText.getText().length() < 8){ // add text if < 8
                passwordText.append(buttonText);
            }
            // writing done on textView only if switch is not enable and button1 is not enabled and game is not successfully over
            else if(!writeSwitch.isChecked() && !button1.isEnabled() &&!inputText.getText().toString().equals(passwordText.getText().toString())){
                if(!worngLetterEntered){
                    if(inputText.getText().length() < 8) { // add text if < 8
                        String password = passwordText.getText().toString();
                        int index = inputText.getText().length(); // index we want to write on
                        if(index < password.length()){ // prevents writing more chars than the password
                            inputText.append(buttonText);
                            if(buttonText.charAt(0) == password.charAt(index)){ // if added letter is correct
                                score++; // increment score
                                scoreText.setText("Score: " + score);
                                if(inputText.getText().toString().equals(password)){ // if game success
                                    button2.setEnabled(true);
                                    outputText.setText("Success!");
                                }
                            }
                            else { // added letter is incorrect
                                worngLetterEntered = true; // prevent the user from adding a new letter before deleting the incorrect letter
                                attempts--; // decrement attempts
                                attemptsText.setText("# attempts: " + attempts);
                                if(attempts == 0){ // no more attempts are available
                                    restartApp();
                                }
                            }
                        }
                    }
                }
                else{
                    Toast toast =Toast.makeText(MainActivity.this, "Remove incorrect letter before continuing",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }

        });
    }

    // reset all variables to restart the game
    public void restartApp(){
        passwordText.setText("");
        passwordText.setEnabled(true);
        inputText.setText("");
        button1.setEnabled(true);
        button2.setEnabled(false);
        score = 0;
        scoreText.setText("Score: 0");
        attempts = 3;
        attemptsText.setText("# Attempts: 3");
        outputText.setText("Output Text");
        worngLetterEntered = false;
    }
}