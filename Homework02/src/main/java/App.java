import cs3331Helper.cs3331TicTacToeFrame;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public void start(Stage stage) {
        cs3331TicTacToeFrame frame = new cs3331TicTacToeFrame(stage);

        TicTacToe game = new TicTacToe();
        frame.addGame(game);

        game.restartGame();
    }

    public static void main(String[] args) {
        launch(args);
    }

}