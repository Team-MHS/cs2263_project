/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hw04;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
    static UserInterface ui = new UserInterface();

    @Override
    public void start(Stage stage) throws Exception {
        UserInterface userInterface = new UserInterface();
        userInterface.welcomeScreen(stage);
    }
    public static void main(String[] args) {
//        Game g = new Game();
//        g.newGame();

        Application.launch();

    }
}
