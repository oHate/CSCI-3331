import fruitNinjaHelper.Constants;

public enum FruitType {
    APPLE(Constants.APPLE_PATH, 2),
    LEMON(Constants.LEMON_PATH, 2),
    PEAR(Constants.PEAR_PATH, 3),
    PEACH(Constants.PEACH_PATH, 5);

    private final String imagePath;
    private final int points;

    FruitType(String imagePath, int points) {
        this.imagePath = imagePath;
        this.points = points;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public int getPoints() {
        return this.points;
    }

    public FruitNode createFruitNode() {
        return new FruitNode(this);
    }

    public static FruitNode getRandomFruitNode() {
        return values()[(int) (Math.random() * values().length)].createFruitNode();
    }

}
