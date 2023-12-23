package project;

import java.util.Arrays;

public class Warehouse extends Storage{
    final int idWarehouse;
    private int warehouseCapacity;
    private int[] warehouseSlots;
    private int idEmployeeWarehouse;
    private String aboutWarehouse;
    private int warehouseFullness;
    private String addressWarehouse;

    public Warehouse(int idWarehouse, int warehouseCapacity,
                     int idEmployeeWarehouse, String aboutWarehouse,
                     String addressWarehouse) {
        this.idWarehouse = idWarehouse;
        this.warehouseCapacity = warehouseCapacity;
        this.idEmployeeWarehouse = idEmployeeWarehouse;
        this.aboutWarehouse = aboutWarehouse;
        this.warehouseFullness = 0;
        this.addressWarehouse = addressWarehouse;
        this.warehouseSlots = new int[warehouseCapacity];
    }

    @Override
    public void increaseCapacity(){
        warehouseFullness++;
    }

    public int[] getSlotsWarehouse() {
        return warehouseSlots;
    }

    public void setWarehouseSlots(int[] slots) {
        warehouseSlots = Arrays.copyOf(slots, slots.length);
    }

    public void transferGoods(PointOfSale place, int idProduct, int idPosition) {
        if (place.checkProductAvailability(0) && checkProductAvailability(idProduct) && warehouseSlots[idPosition] == idProduct) {
            int[] slotsPlace = place.getSlotsPointOfSale();
            for (int i = 0; i < slotsPlace.length; i++) {
                if (slotsPlace[i] == 0) {
                    slotsPlace[i] = idProduct;
                    place.increaseCapacity();
                    warehouseFullness--;
                    place.setPointOfSaleSlots(slotsPlace);
                    break;
                }
            }
            warehouseSlots[idPosition] = 0;
        } else {
            System.out.println("Некорректный ввод!");
        }
    }

    @Override
    public boolean checkProductAvailability(int idProduct) {
        for (int warehouseSlot : warehouseSlots) {
            if (idProduct == warehouseSlot) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void clearingSlots() {
        for (int i = 0; i < warehouseSlots.length; i++) {
            for (int j = 0; j < this.slots.length; j++) {
                if (warehouseSlots[i] == this.slots[j]) {
                    this.slots[j] = 0;
                    this.warehouseSlots[i] = 0;
                    this.fullness--;
                    break;
                }
            }
        }
    }

    @Override
    public void closeEnterprise() {
        this.warehouseCapacity = 0;
        this.aboutWarehouse = null;
        this.addressWarehouse = null;
        clearingSlots();
    }

    @Override
    public void changeData(int capacity, int idEmployee, String about) {
        this.warehouseCapacity = capacity;
        clearingSlots();
        this.idEmployeeWarehouse = idEmployee;
        this.aboutWarehouse = about;
        this.warehouseFullness = 0;
    }

    @Override
    public void content(int numberProduct, int[] content) {
        if (numberProduct + warehouseFullness > warehouseCapacity) {
            System.out.println("Невозможная величина! Склад переполнен!");
        } else {
            int count = 0;
            for (int i = 0; i < numberProduct; i++) {
                for (int j = 0; j < warehouseCapacity; j++) {
                    if (warehouseSlots[j] == 0) {
                        warehouseSlots[j] = content[count];
                        this.slots[j] = content[count];
                        warehouseFullness++;
                        this.fullness++;
                        count++;
                        break;
                    }
                }
            }
            if (count != numberProduct) {
                System.out.println("Не получилось добавить все товары, так как склад переполнен!");
                for (int i = count; i < numberProduct; i++) {
                    System.out.println("id: " + content[i]);
                }
            }
        }
    }

    @Override
    public void dataOutput(Employee[] employeeArray) {
        System.out.println("id склада: " + idWarehouse);
        System.out.println("Вместимость склада: " + warehouseCapacity);
        System.out.println("Заполненность склада: " + warehouseFullness);
        System.out.println("ответственный работник: " );
        employeeArray[idEmployeeWarehouse].humanDataOutput();
        System.out.println("Адрес склада: " + addressWarehouse);
        System.out.println("Описание склада: " + aboutWarehouse);
        for (int i = 0; i < warehouseFullness; i++) {
            System.out.println("Содержимое склада " + (i + 1) + ": " + warehouseSlots[i]);
        }
    }
}