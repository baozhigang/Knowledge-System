import java.util.ArrayList;

public class PancakeHouseMenuIterator implements Iterator {
    ArrayList menuItems;
    int position = 0;

    public PancakeHouseMenuIterator(ArrayList menuItems) {
        this.menuItems = menuItems;
    }

    public Object next() {
        MenuItem menuItem = (MenuItem) menuItems.get(position);
        position++;
        return menuItem;
    }

    public boolean hasNext() {
        if (position >= menuItems.size() || menuItems.get(position) == null) {
            return false;
        } else {
            return true;
        }
    }

}
