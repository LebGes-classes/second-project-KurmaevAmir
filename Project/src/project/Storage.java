package project;
abstract class Storage{
    private int id;
    protected String address;
    protected int capacity = 1000;
    private int idOfThePersonInChange;
    protected int fullness;
    protected int[] slots = new int[1000];

    protected abstract void increaseCapacity();
    protected abstract boolean checkProductAvailability(int idProduct);
    protected abstract void closeEnterprise();
    protected abstract void changeData(int capacity, int idEmployee, String about);
    protected abstract void content(int numberProduct, int[] content);
    protected abstract void dataOutput(Employee[] employeeArray);
    protected abstract void clearingSlots();

    protected void addingProduct(int numberProducts, int idProduct) {
        if (fullness + numberProducts > capacity) {
            System.out.println("Лимит хранилища превышен!");
        }
        else {
            for (int i = 0; i < numberProducts; i++) {
                for (int j = 0; j < slots.length; j++) {
                    if (slots[j] == 0) {
                        slots[j] = idProduct;
                        fullness++;
                        break;
                    }
                }
            }
        }
    }
}