import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MemoryMatchFrame {

    private final BorderPane root;

    public MemoryMatchFrame(Stage stage) {
        this.root = new BorderPane();
        Scene scene = new Scene(this.root);
        stage.setScene(scene);
    }

    public void setGame(MemoryMatchGame game) {
        this.root.setCenter(game.getGamePane());
        setupTimer(game.getTimer());
    }

    private void setupTimer(Timer timer) {
        Label timerLabel = new Label("Click a button to start!");

        HBox timerBox = new HBox(timerLabel);
        timerBox.setAlignment(Pos.CENTER);

        SimpleIntegerProperty property = new SimpleIntegerProperty(-1);
        property.addListener((ov) -> timerLabel.setText("Time Elapsed: " + property.get() + " secs"));

        timer.setProperty(property);

        this.root.setBottom(timerBox);
    }

}
