package project;
abstract class Storage{
    private int idStorage;
    private String addressStorage;
    private int capacityStorage;
    private int idOfThePersonInChangeStorage;
    private int fullnessStorage;
    private int[] storageSlots;

    protected abstract void transferGoods(int idPlace, int idSlot);
    protected abstract boolean checkProductAvailability(int idProduct);
    protected abstract void closeEnterprise();
    protected abstract void changeData();
    protected abstract int[] content();
}