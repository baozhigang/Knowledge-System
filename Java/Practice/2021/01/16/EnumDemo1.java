public class EnumDemo1 {
    enum Color {
        RED, GREEN, BLUE
    }

    public static void main(String[] args) {
        Color c1 = Color.RED;
        System.out.println(c1);

        for (Color c : Color.values()) {
            System.out.println(c.ordinal());
        }

        System.out.println(Color.valueOf("RED"));
    }
}
