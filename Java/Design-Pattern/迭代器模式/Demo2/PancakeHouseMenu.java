import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu implements Menu {
    ArrayList menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList();
        addItem("a", "aaa", true, 2.99);
        addItem("b", "bbb", false, 2.99);
        addItem("c", "ccc", true, 3.49);
        addItem("d", "ddd", true, 3.59);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public Iterator createIterator() {
        return (Iterator) menuItems.iterator();
    }
}
