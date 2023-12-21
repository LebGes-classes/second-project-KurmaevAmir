package project;

import java.util.Arrays;

public class Warehouse extends Storage{
    private int idWarehouse;
    private int warehouseCapacity;
    private int[] warehouseSlots;
    private int idEmployeeWarehouse;
    private String aboutWarehouse;
    private int warehouseFullness;
    private String addressWarehouse;

    public Warehouse(int idWarehouse, int warehouseCapacity,
                     int[] warehouseSlots, int idEmployeeWarehouse,
                     String aboutWarehouse, int warehouseFullness,
                     String addressWarehouse) {
        this.idWarehouse = idWarehouse;
        this.warehouseCapacity = warehouseCapacity;
        this.warehouseSlots = warehouseSlots;
        this.idEmployeeWarehouse = idEmployeeWarehouse;
        this.aboutWarehouse = aboutWarehouse;
        this.warehouseFullness = warehouseFullness;
        this.addressWarehouse = addressWarehouse;
    }

    @Override
    public void transferGoods(int idPlace, int idSlot) {
    }

    @Override
    public boolean checkProductAvailability(int idProduct) {
        for (int i = 0; i < warehouseSlots.length; i++) {
            if (idProduct == warehouseSlots[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void closeEnterprise() {
        this.warehouseCapacity = 0;
        this.aboutWarehouse = null;
        this.addressWarehouse = null;
        this.warehouseSlots = new int[warehouseSlots.length];
    }

    @Override
    public void changeData(int capacity, int[] slots, int idEmployee, String about, int fullness) {
        this.warehouseCapacity = capacity;
        this.warehouseSlots = slots;
        this.idEmployeeWarehouse = idEmployee;
        this.aboutWarehouse = about;
        this.warehouseFullness = fullness;
    }

    @Override
    public void content(int[] content) {
        this.warehouseSlots = content;
    }
}