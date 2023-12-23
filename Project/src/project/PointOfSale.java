package project;

import java.util.Arrays;

public class PointOfSale extends Storage {
    final int idPointOfSale;
    private int pointOfSaleCapacity;
    private int[] pointOfSaleSlots;
    private int idEmployeePointOfSale;
    private String aboutPointOfSale;
    private int pointOfSaleFullness;
    private String addressPointOfSale;

    public PointOfSale(int idPointOfSale, int pointOfSaleCapacity,
                       int idEmployeePointOfSale, String aboutPointOfSale,
                       String addressPointOfSale) {
        this.idPointOfSale = idPointOfSale;
        this.pointOfSaleCapacity = pointOfSaleCapacity;
        this.pointOfSaleSlots = new int[pointOfSaleCapacity];
        this.idEmployeePointOfSale = idEmployeePointOfSale;
        this.aboutPointOfSale = aboutPointOfSale;
        this.pointOfSaleFullness = 0;
        this.addressPointOfSale = addressPointOfSale;
    }

    @Override
    public void increaseCapacity(){
        pointOfSaleFullness++;
    }

    public int[] getSlotsPointOfSale() {
        return pointOfSaleSlots;
    }

    public void setPointOfSaleSlots(int[] slots) {
        pointOfSaleSlots = Arrays.copyOf(slots, slots.length);
    }

    public void transferGoodsToWarehouse(Warehouse place, int idProduct, int idPosition) {
        if (place.checkProductAvailability(0) && checkProductAvailability(idProduct) && pointOfSaleSlots[idPosition] == idProduct) {
            int[] slotsPlace = place.getSlotsWarehouse();
            for (int i = 0; i < slotsPlace.length; i++) {
                if (slotsPlace[i] == 0) {
                    slotsPlace[i] = idProduct;
                    place.increaseCapacity();
                    pointOfSaleFullness--;
                    place.setWarehouseSlots(slotsPlace);
                    break;
                }
            }
            pointOfSaleSlots[idPosition] = 0;
        } else {
            System.out.println("Некорректный ввод!");
        }
    }

    @Override
    public boolean checkProductAvailability(int idProduct) {
        for (int pointOfSaleSlot : pointOfSaleSlots) {
            if (idProduct == pointOfSaleSlot) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void clearingSlots(){
        for (int i = 0; i < pointOfSaleSlots.length; i++) {
            for (int j = 0; j < this.slots.length; j++) {
                if (pointOfSaleSlots[i] == this.slots[j]) {
                    this.slots[j] = 0;
                    this.pointOfSaleSlots[i] = 0;
                    this.fullness--;
                    break;
                }
            }
        }
    }

    @Override
    public void closeEnterprise() {
        this.pointOfSaleCapacity = 0;
        this.aboutPointOfSale = null;
        this.addressPointOfSale = null;
        clearingSlots();
    }

    @Override
    public void changeData(int capacity, int idEmployee, String about) {
        this.pointOfSaleCapacity = capacity;
        clearingSlots();
        this.idEmployeePointOfSale = idEmployee;
        this.aboutPointOfSale = about;
        this.pointOfSaleFullness = 0;
    }

    @Override
    public void content(int numberProduct, int[] content) {
        if (numberProduct + pointOfSaleFullness > pointOfSaleCapacity) {
            System.out.println("Невозможная величина! Склад переполнен!");
        } else {
            int count = 0;
            for (int i = 0; i < numberProduct; i++) {
                for (int j = 0; j < pointOfSaleSlots.length; j++) {
                    if (pointOfSaleSlots[j] == 0) {
                        pointOfSaleSlots[j] = content[count];
                        pointOfSaleFullness++;
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
        System.out.println("id склада: " + idPointOfSale);
        System.out.println("Вместимость склада: " + pointOfSaleCapacity);
        System.out.println("Заполненность склада: " + pointOfSaleFullness);
        System.out.println("id ответственного работника: ");
        employeeArray[idEmployeePointOfSale].humanDataOutput();
        System.out.println("Адрес склада: " + addressPointOfSale);
        System.out.println("Описание склада: " + aboutPointOfSale);
        for (int i = 0; i < pointOfSaleFullness; i++) {
            System.out.println("Содержимое склада " + (i + 1) + ": " + pointOfSaleSlots[i]);
        }
    }
}
