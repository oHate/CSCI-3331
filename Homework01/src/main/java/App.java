import javafx.application.Application;
import javafx.stage.Stage;
import pizzaHelper.CS3331PizzaFrame;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        new CS3331PizzaFrame(stage);
        new PizzaShop();
    }

    public static void main(String[] args) {
        launch(args);
    }

}