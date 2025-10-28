package PWO.lab3.S;

abstract class DeliveryObject {
    private final int id;

    public int getId() {
        return id;
    }

    DeliveryObject(int id){
        this.id = id;
    }
}
