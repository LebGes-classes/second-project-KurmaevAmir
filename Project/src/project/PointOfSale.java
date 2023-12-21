package project;

public class PointOfSale extends Storage {
    private int idPointOfSale;
    private int pointOfSaleCapacity;
    private int[] pointOfSaleSlots;
    private int idEmployeePointOfSale;
    private String aboutPointOfSale;
    private int pointOfSaleFullness;
    private String addressPointOfSale;

    public PointOfSale(int idPointOfSale, int pointOfSaleCapacity,
                       int[] pointOfSaleSlots, int idEmployeePointOfSale,
                       String aboutPointOfSale, int pointOfSaleFullness,
                       String addressPointOfSale) {
        this.idPointOfSale = idPointOfSale;
        this.pointOfSaleCapacity = pointOfSaleCapacity;
        this.pointOfSaleSlots = pointOfSaleSlots;
        this.idEmployeePointOfSale = idEmployeePointOfSale;
        this.aboutPointOfSale = aboutPointOfSale;
        this.pointOfSaleFullness = pointOfSaleFullness;
        this.addressPointOfSale = addressPointOfSale;
    }

    @Override
    public void transferGoods(int idPlace, int idSlots) {

    }

    @Override
    public boolean checkProductAvailability(int idProduct) {
        for (int i = 0; i < pointOfSaleSlots.length; i++) {
            if (idProduct == pointOfSaleSlots[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void closeEnterprise() {
        this.pointOfSaleCapacity = 0;
        this.aboutPointOfSale = null;
        this.addressPointOfSale = null;
        this.pointOfSaleSlots = new int[pointOfSaleSlots.length];
    }

    @Override
    public void changeData(int capacity, int[] slots, int idEmployee, String about, int fullness) {
        this.pointOfSaleCapacity = pointOfSaleCapacity;
        this.pointOfSaleSlots = slots;
        this.idEmployeePointOfSale = idEmployee;
        this.aboutPointOfSale = about;
        this.pointOfSaleFullness = fullness;
    }

    @Override
    public void content(int[] content) { this.pointOfSaleSlots = content; }
}
