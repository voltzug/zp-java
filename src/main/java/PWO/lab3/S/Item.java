package PWO.lab3.S;

public class Item extends DeliveryObject {
    static int ID_COUNTER = 0;
    static final int STATUS_AVAILABLE = 0, STATUS_SOLD = 1;

    private int status;
    private double price;
    private String name;

    public int getStatus() {
        return status;
    }
    public void setSold(boolean sold) {
        if(sold) this.status = STATUS_SOLD;
        else this.status = STATUS_AVAILABLE;
    }

    public String getItemName() {
        return name;
    }
    public void setItemName(String itemName, double price) {
        this.name = itemName;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Item(int id, String itemName, double price) {
        super(id);
        this.name = itemName;
        this.price = price;
    }
    public Item(int id, String itemName, double price, int status) {
        super(id);
        this.name = itemName;
        this.price = price;
        this.status = status;
    }

    public static Item ProduceItem(String name, double price) {
        return new Item(ID_COUNTER++, name, price);
    }
}
