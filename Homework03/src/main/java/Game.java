import fruitNinjaHelper.cs3331Blade;
import fruitNinjaHelper.cs3331FruitNinjaGame;
import fruitNinjaHelper.cs3331ScoreController;

public class Game extends cs3331FruitNinjaGame{

    private static final double BOMB_CHANCE = 0.15;

    private final cs3331ScoreController scoreController;
    private final cs3331Blade blade;

    public Game(cs3331ScoreController scoreController) {
        super();

        this.scoreController = scoreController;
        this.blade = new cs3331Blade("Iron Blade");

        addBlade(blade);

        this.startGame();
    }

    public void updateChoppable(Object object) {
        if (!(object instanceof GameObject obj)) {
            return;
        }

        boolean intersected = this.blade.checkIntersection(obj);

        if (intersected) {
            int points = obj.chop();
            this.scoreController.addToScore(points);
        } else {
            obj.move();
        }
    }

    @Override
    public Object launchItem() {
        boolean isBomb = Math.random() < BOMB_CHANCE;

        if (isBomb) {
            return new BombNode();
        } else {
            FruitNode fruit = FruitType.getRandomFruitNode();

            fruit.wash();
            fruit.ripen();

            return fruit;
        }
    }

    @Override
    public void updateChoppableHelper() {
        this.updateChoppable(this.getCurrentItem());
    }

}