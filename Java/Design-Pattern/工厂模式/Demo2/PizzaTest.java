public class PizzaTest {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chiStore = new ChicagoStylePizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("A ordered a " + pizza.getName());

        Pizza pizza1 = chiStore.orderPizza("cheese");
        System.out.println("B ordered a " + pizza1.getName());
    }
}
