import fruitNinjaHelper.cs3331Fruit;

public class FruitNode extends cs3331Fruit implements GameObject {

    private final FruitType type;

    public FruitNode(FruitType type) {
        super();
        this.type = type;
        setImage(type.getImagePath());
    }

    @Override
    public int chop() {
        chopGraphically();
        splash();
        return this.type.getPoints();
    }

    @Override
    public void move() {
        moveFruit();
    }

}
