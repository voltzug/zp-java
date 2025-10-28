package PWO.lab3.S;

import java.util.ArrayList;
import java.util.HashMap;

public class InternetStore {
    static HashMap<Integer,Item> items = new HashMap<>();

    public static void addItemToStorage(Item item) {
        items.put(item.getId(), item);
    }

    public static void removeItemFromStorage(int itemId) {
        items.remove(itemId);
    }

    public static boolean sellItemFromStorage(int itemId) {
        Item item = items.get(itemId);
        if(item == null) return false;
        item.setSold(true);
        return true;
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 9; i++) addItemToStorage(Item.ProduceItem("Ragu", 9.89));
        Client client = new Client(0, "Test", "pollub street");
        FoodDelivery fd = new FoodDelivery(0,client);
        var itm = items.get(0);
        fd.addItem(itm);
        fd.finalizeOrder();
        fd.doDelivery();
    }
}
