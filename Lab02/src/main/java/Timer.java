import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Timer implements EventHandler<ActionEvent> {

    private final Timeline timeline;
    private IntegerProperty property;

    public Timer() {
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), this);
        this.timeline = new Timeline(keyFrame);
        this.timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void start() {
        if (this.property == null) {
            throw new NullPointerException("Property has not been set");
        }

        this.property.setValue(0);
        this.timeline.play();
    }

    public void stop() {
        this.timeline.stop();
    }

    public void setProperty(IntegerProperty property) {
        this.property = property;
    }

    public boolean hasStarted() {
        return this.property.get() != 0 && this.timeline.getCurrentRate() != 0;
    }

    @Override
    public void handle(ActionEvent event) {
        this.property.setValue(this.property.getValue() + 1);
    }

}
