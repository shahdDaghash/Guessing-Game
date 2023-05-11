#Android Password Guessing Game
This project is an Android app for a two-player password guessing game. The game has two modes: user1 mode, where the first player sets a password, and user2 mode, where the second player attempts to guess the password.

##Setup and Usage
To use this app, simply download and install the APK file on an Android device. Once the app is launched, the user is presented with the user1 mode, where they can set the password.

In user1 mode, the user can set a password of up to 8 characters in length by typing the password in the text field and then clicking the "Save Password" button. The user can also use the on-screen keyboard to enter the password. Once the password is set, the app will switch to user2 mode, where the second player can start guessing the password.

In user2 mode, the user is presented with a keyboard and a text field. The user can use the keyboard to enter letters and try to guess the password. If the user enters an incorrect letter, the app will prevent them from adding a new letter until they delete the wrong letter. The user has three attempts to guess the password correctly. If the user guesses the password correctly, the app displays a success message and allows the user to restart the game by clicking the "Restart" button.

Functionality
The app is implemented using Java and the Android SDK. It includes the following features:

Two-player password guessing game
User1 mode for setting the password
User2 mode for guessing the password
On-screen keyboard for entering letters
Text field for displaying input and output
Buttons for deleting text and restarting the game
Switch for enabling/disabling password writing in user2 mode
Scoreboard for keeping track of the user's score and number of attempts
Toast messages for displaying error and success messages
Implementation Details
The app is implemented using the Model-View-Controller (MVC) architectural pattern. The Model consists of the data structures and game logic, the View consists of the UI components, and the Controller consists of the event handlers and communication between the Model and View.

The app uses the following classes and components:

MainActivity: The main activity class that handles the UI and event handling.
EditText: A UI component for displaying and editing text.
Switch: A UI component for enabling/disabling a feature.
TextView: A UI component for displaying text.
Button: A UI component for triggering an action.
Toast: A UI component for displaying short messages.
KeyEvent: An Android class for handling keyboard events.
MotionEvent: An Android class for handling touch events.
The app also includes several helper methods and variables for setting up the UI and game logic.
