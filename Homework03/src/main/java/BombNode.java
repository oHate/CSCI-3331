import fruitNinjaHelper.cs3331Bomb;

public class BombNode extends cs3331Bomb implements GameObject {

    public BombNode() {
        setImage();
    }

    @Override
    public int chop() {
        explode();
        return 0;
    }

    @Override
    public void move() {
        moveBomb();
    }

}
