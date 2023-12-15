package project;

public class Storage {
    private int id;
    private String address;
    private double capacity;
    private int idOfThePersonInCharge;
    private double fullness;

    public Storage(int id, String address, double capacity,
                   int idOfThePersonInCharge, double fullness) {
        this.id = id;
        this.address = address;
        this.capacity = capacity;
        this.idOfThePersonInCharge = idOfThePersonInCharge;
        this.fullness = fullness;
    }

    public void changeInStorageVolume (double capacity) {
        this.capacity = capacity;
    }
}
