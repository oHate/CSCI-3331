import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public void start(Stage stage) {
        MemoryMatchFrame frame = new MemoryMatchFrame(stage);
        frame.setGame(new MemoryMatchGame());

        stage.setTitle("Memory Match");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
