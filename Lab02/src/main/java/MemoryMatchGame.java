import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoryMatchGame {

    private static final String[] EMOJIS = {"🐶", "🐱", "🦊", "🐼", "🐵", "🐸", "🦉", "🐢"};

    private final GridPane gamePane;
    private final Timer timer;

    public MemoryMatchGame() {
        this.timer = new Timer();

        List<String> deck = new ArrayList<>();

        for (String emoji : EMOJIS) {
            deck.add(emoji);
            deck.add(emoji);
        }

        Collections.shuffle(deck);

        this.gamePane = new GridPane();
        this.gamePane.setAlignment(Pos.CENTER);

        MemoryMatchButtonHandler handler = new MemoryMatchButtonHandler(this);

        for (int i = 0; i < 16; i++) {
            MemoryMatchButton button = new MemoryMatchButton(deck.get(i));
            button.setOnAction(handler::handleButtonEvent);

            this.gamePane.add(button, i % 4, i / 4);
        }
    }

    public GridPane getGamePane() {
        return this.gamePane;
    }

    public Timer getTimer() {
        return this.timer;
    }

}
