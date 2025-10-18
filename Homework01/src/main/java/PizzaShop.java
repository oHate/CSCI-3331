import pizzaHelper.CS3331Pizza;
import pizzaHelper.CS3331Toppings;
import pizzaHelper.PizzaShopHelper;

public class PizzaShop extends PizzaShopHelper {

    private final CS3331Toppings toppings;
    private final Baker baker;

    public PizzaShop() {
        super();

        this.toppings = new CS3331Toppings();
        this.baker = new Baker();

        openShop();
    }

    @Override
    public void openShop() {
        displayShopUpdate("We are open for business");
    }

    @Override
    public void order1() {
        CS3331Pizza pizza = this.baker.bakeMushroomPizza();
        displayPrice(pizza);
        displayBakersUpdate();
    }

    @Override
    public void order2() {
        CS3331Pizza pizza = this.baker.bakePineapplePizza();
        this.toppings.addPeppers(pizza);
        displayPrice(pizza);
        displayBakersUpdate();
    }

    @Override
    public void order3(){
        CS3331Pizza pizza = this.baker.bakePineapplePizza();
        this.toppings.addPeppers(pizza);
        this.toppings.addTomatoes(pizza);
        displayPrice(pizza);
        displayBakersUpdate();
    }

    @Override
    public void order4() {
        CS3331Pizza pizza = this.baker.bakeSpinachPizza();
        this.toppings.addPeppers(pizza);
        this.toppings.addTomatoes(pizza);
        displayPrice(pizza);
        displayBakersUpdate();
    }

    private void displayBakersUpdate() {
        displayShopUpdate(this.baker.toString());
    }

}