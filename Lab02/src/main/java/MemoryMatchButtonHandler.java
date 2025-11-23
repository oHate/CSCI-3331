import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.util.Duration;

public class MemoryMatchButtonHandler {

    private static final int TOTAL_PAIRS = 8;

    private final MemoryMatchGame game;
    private final PauseTransition pause;

    private MemoryMatchButton firstClickedButton;
    private MemoryMatchButton secondClickedButton;

    private boolean lockClicks = false;
    private int pairsFound = 0;

    public MemoryMatchButtonHandler(MemoryMatchGame game) {
        this.game = game;
        this.pause = new PauseTransition(Duration.seconds(1));
        this.pause.setOnFinished(this::handlePauseEvent);
    }

    public void handleButtonEvent(ActionEvent event) {
        if (!(event.getSource() instanceof MemoryMatchButton button) || this.lockClicks || button.isDisabled()) {
            return;
        }

        Timer timer = this.game.getTimer();

        if (!timer.hasStarted()) {
            timer.start();
        }

        button.show();

        if (this.firstClickedButton == null) {
            this.firstClickedButton = button;
        } else {
            this.lockClicks = true;
            this.secondClickedButton = button;
            this.pause.play();
        }
    }

    private void handlePauseEvent(ActionEvent event) {
        if (this.firstClickedButton.equals(this.secondClickedButton)) {
            this.pairsFound++;

            if (this.pairsFound == TOTAL_PAIRS) {
                this.game.getTimer().stop();
            }
        } else {
            this.firstClickedButton.hide();
            this.secondClickedButton.hide();
        }

        this.firstClickedButton = null;
        this.lockClicks = false;
    }

}
