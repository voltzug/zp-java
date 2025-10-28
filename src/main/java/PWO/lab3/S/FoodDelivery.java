package PWO.lab3.S;

import java.util.ArrayList;
import java.util.List;

public final class FoodDelivery extends DeliveryObject {
    private boolean isConfirmed;
    private double totalBill;
    private final Client customer;
    private final List<Item> items;

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public int getQuantity() {
        return items.size();
    }

    public double getTotalBill() {
        return calculateBill();
    }

    public FoodDelivery(int id, Client customer) {
        super(id);
        this.customer = customer;
        this.isConfirmed = false;
        this.totalBill = 0;
        this.items = new ArrayList<>();
    }
    public FoodDelivery(int id, Client customer, List<Item> items) {
        super(id);
        this.customer = customer;
        this.isConfirmed = false;
        this.totalBill = 0;
        this.items = new ArrayList<>(items);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    double calculateBill(){
        totalBill = 0;
        items.forEach(item -> this.totalBill += item.getPrice());
        return totalBill;
    }

    public void finalizeOrder() throws Exception {
        if (isConfirmed) throw new Exception("Order has been already confirmed");
        items.forEach(item -> InternetStore.sellItemFromStorage(item.getId()));
        calculateBill();
        isConfirmed = true;
    }

    public void doDelivery() {
        System.out.println("Delivering the order for Customer" + customer.getName());
        items.forEach(item -> InternetStore.removeItemFromStorage(item.getId()));
        System.out.println("Order with order id="
                + getId() + " is being delivered.");
        System.out.println("Order is to be delivered to: "
                        + customer.getAddress());
    }
}
