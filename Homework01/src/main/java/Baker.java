import pizzaHelper.CS3331Pizza;

public class Baker {

    private int pizzasBaked = 0;

    public CS3331Pizza bakeMushroomPizza() {
        this.pizzasBaked++;

        CS3331Pizza pizza = new CS3331Pizza();
        pizza.addMushrooms();
        return pizza;
    }

    public CS3331Pizza bakePineapplePizza() {
        this.pizzasBaked++;

        CS3331Pizza pizza = new CS3331Pizza();
        pizza.addPineapple();
        return pizza;
    }

    public CS3331Pizza bakeSpinachPizza() {
        this.pizzasBaked++;

        CS3331Pizza pizza = new CS3331Pizza();
        pizza.addSpinach();
        return pizza;
    }

    @Override
    public String toString() {
        return "The baker has made " + this.pizzasBaked + " pizzas.";
    }

}
