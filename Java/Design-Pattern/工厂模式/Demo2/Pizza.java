public class Pizza {
    String name;
    String sauce;

    void prepare() {
        System.out.println("name " + name);
        System.out.println("sauce " + sauce);
    }

    void bake() {
        System.out.println("bake");
    }

    void cut() {
        System.out.println("cut");
    }

    void box() {
        System.out.println("box");
    }

    public String getName() {
        return name;
    }
}
