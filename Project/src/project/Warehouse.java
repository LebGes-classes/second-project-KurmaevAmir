package project;

import java.util.Arrays;

public class Warehouse extends Storage{
    private int idWarehouse;
    private int warehouseCapacity;
    private int[] warehouseSlots;
    private int idEmployeeWarehouse;
    private String aboutWarehouse;

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
        this.warehouseSlots = new int[warehouseSlots.length];
    }

    @Override
    public void changeData() {
    }
}