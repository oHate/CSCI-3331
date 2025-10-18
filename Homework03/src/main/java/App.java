import fruitNinjaHelper.cs3331FruitNinjaFrame;
import fruitNinjaHelper.cs3331ScoreController;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public void start(Stage primaryStage) {
        cs3331FruitNinjaFrame frame = new cs3331FruitNinjaFrame(primaryStage);
        cs3331ScoreController scoreController = new cs3331ScoreController();

        frame.addGame(new Game(scoreController));
        frame.setTop(scoreController);
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

}