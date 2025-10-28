package PWO.lab3.S;

public class Client extends DeliveryObject {
    private String name;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Client(int id, String name, String address) {
        super(id);
        this.name = name;
        this.address = address;
    }
}
