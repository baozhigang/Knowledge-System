public class PizzaStrore {
    SimplePizzaFactory factory;

    public PizzaStrore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        return pizza;
    }
}
