package project;

public class Catalog {
    protected int id;
    protected String name;
    protected String size;
    protected int purchasePrice;
    protected String description;
    protected String deliveryDeadline;

    public Catalog(int id, String name, String size, int purchasePrice, String description, String deliveryDeadline) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.purchasePrice = purchasePrice;
        this.description = description;
        this.deliveryDeadline = deliveryDeadline;
    }

    public void catalogDataOutput() {
        System.out.println("id: " + id);
        System.out.println("Название: " + name);
        System.out.println("Размеры товара: " + size);
        System.out.println("Цена закупки: " + purchasePrice);
        System.out.println("Описание товара: " + description);
        System.out.println("Дата окончания доставки товара: " + deliveryDeadline);
    }

    public String[] getStringData(){
        String[] stringData = new String[4];
        stringData[0] = name;
        stringData[1] = size;
        stringData[2] = description;
        stringData[3] = deliveryDeadline;
        return stringData;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
