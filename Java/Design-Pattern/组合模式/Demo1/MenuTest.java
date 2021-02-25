public class MenuTest {
    public static void main(String[] args) {
        MenuComponent pmenu = new Menu("PMenu", "Breakfast");
        MenuComponent dmenu = new Menu("Dmenu", "Lunch");
        MenuComponent allmenu = new Menu("All Menu", "All Menu");

        allmenu.add(pmenu);
        allmenu.add(dmenu);
        allmenu.add(allmenu);

        pmenu.add(new MenuItem("a", "aaa", 3.89, true));
        dmenu.add(new MenuItem("b", "bbb", 4.89, true));

        Waitress waitress = new Waitress(allmenu);
        waitress.printMenu();
    }
}
