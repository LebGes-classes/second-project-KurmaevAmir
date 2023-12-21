package project;
abstract class Storage{
    private int id;
    private String address;
    private int capacity;
    private int idOfThePersonInChange;
    private int fullness;
    private int[] slots;

    protected abstract void transferGoods(int idPlace, int idSlot);
    protected abstract boolean checkProductAvailability(int idProduct);
    protected abstract void closeEnterprise();
    protected abstract void changeData(int capacity, int[] slots, int idEmployee, String about, int fullness);
    protected abstract void content(int[] content);
}