# Android Password Guessing Game
This project is an Android app for a two-player password guessing game. The game has two modes: user1 mode, where the first player sets a password, and user2 mode, where the second player attempts to guess the password.

![Password Guessing Game](https://github.com/shahdDaghash/Guessing-Game/blob/master/view.png)

## Setup and Usage
To use this app, simply download and install the APK file on an Android device. Once the app is launched, the user is presented with the user1 mode, where they can set the password.

In user1 mode, the user can set a password of up to 8 characters in length by typing the password in the text field and then clicking the "Save Password" button. The user can also use the on-screen keyboard to enter the password. Once the password is set, the app will switch to user2 mode, where the second player can start guessing the password.

In user2 mode, the user is presented with a keyboard and a text field. The user can use the keyboard to enter letters and try to guess the password. If the user enters an incorrect letter, the app will prevent them from adding a new letter until they delete the wrong letter. The user has three attempts to guess the password correctly. If the user guesses the password correctly, the app displays a success message and allows the user to restart the game by clicking the "Restart" button.

## Languages And Tools:

- <img align="left" alt="Java" width="40px" src="https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/1200px-Java_programming_language_logo.svg.png" /> <img align="left" alt=  "Android Studio" width="50px" src="https://1.bp.blogspot.com/-LgTa-xDiknI/X4EflN56boI/AAAAAAAAPuk/24YyKnqiGkwRS9-_9suPKkfsAwO4wHYEgCLcBGAsYHQ/s0/image9.png" />
<br/>


## Functionality
The app is implemented using Java and the Android SDK. It includes the following features:

* Two-player password guessing game
* User1 mode for setting the password
* User2 mode for guessing the password
* On-screen keyboard for entering letters
* Scoreboard for keeping track of the user's score and number of attempts
* Toast messages for displaying error and success messages

## Implementation Details
The app is implemented using the Model-View-Controller (MVC) architectural pattern. The Model consists of the data structures and game logic, the View consists of the UI components, and the Controller consists of the event handlers and communication between the Model and View.
