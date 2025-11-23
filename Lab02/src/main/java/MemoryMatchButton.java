import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class MemoryMatchButton extends Button {

    private static final Font FONT = Font.font(32);

    private final String emoji;

    public MemoryMatchButton(String emoji) {
        super("?");
        this.emoji = emoji;

        setFocusTraversable(false);
        setMinSize(100, 100);
        setFont(FONT);
    }

    public void show() {
        setText(this.emoji);
        setDisable(true);
    }

    public void hide() {
        setText("?");
        setDisable(false);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MemoryMatchButton other)) {
            return false;
        }

        return this.emoji.equals(other.emoji);
    }

}
