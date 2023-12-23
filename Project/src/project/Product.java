package project;

public class Product extends Catalog{
    final int idProduct;
    private int idCatalog;
    private int idOfThePersonInChange;
    private double sellingPrice;

    public Product(int idProduct, String name, String size, int purchasePrice, String description, String deliveryDeadline,
                   int idCatalog, int idOfThePersonInChange, double sellingPrice) {
        super(idCatalog, name, size, purchasePrice, description, deliveryDeadline);
        this.idProduct = idProduct;
        this.idCatalog = idCatalog;
        this.idOfThePersonInChange = idOfThePersonInChange;
        this.sellingPrice = sellingPrice;
    }

    public void productDataOutput() {
        System.out.println("id Каталога: " + idCatalog);
        System.out.println("Название: " + name);
        System.out.println("Размеры товара: " + size);
        System.out.println("Цена закупки: " + purchasePrice);
        System.out.println("Описание товара: " + description);
        System.out.println("Дата окончания доставки товара: " + deliveryDeadline);
        System.out.println("id товара: " + idProduct);
        System.out.println("ID ответственного: " + idOfThePersonInChange);
        System.out.println("Цена продажи: " + sellingPrice);
    }
}
