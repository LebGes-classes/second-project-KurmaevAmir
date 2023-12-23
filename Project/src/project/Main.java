package project;

import java.util.Scanner;

public class Main {
    final static Scanner scan = new Scanner(System.in);
    final static Warehouse[] warehouseArray = new Warehouse[50];
    final static PointOfSale[] pointOfSaleArray = new PointOfSale[50];
    final static Employee[] employeeArray = new Employee[500];
    final static Buyer[] buyerArray = new Buyer[1500000];
    final static Catalog[] catalogArray = new Catalog[1000];
    final static Product[] productArray = new Product[1000000];
    public static void main(String[] args) {
        introduction();
    }

    public static void introduction(){
        String[] introductionArray = {"................................", "Добро пожаловать в консольное приложение",
                "по управлению склада", "Для управления приложением необходимо использовать следующие команды: ",
                "1. Создание", "\t1.1 /creatingWarehouse - создание склада", "\t1.2 /creatingPointOfSale - создание пункта продаж",
                "\t1.3 /addingEmployee - добавление сотрудника", "\t1.4 /addingBuyer - добавление покупателя",
                "2. Добавление товаров", "\t2.1 /addingProductWarehouse - добавление товара в склад",
                "\t2.2 /addingProductPointOfSale - добавление товара в пункт продаж",
                "\t2.3 /addingCatalog - добавление товара в каталог", "\t2.4 /addingProduct - добавление товара",
                "3. Вывод данных",
                "\t3.1 /dataWarehouseOutput - вывод данных склада", "\t3.2 /dataPointOfSaleOutput - вывод данных пункта продаж",
                "\t3.3 /dataEmployeeOutput - вывод данных сотрудника", "\t3.4 /dataBuyerOutput - вывод данных покупателя",
                "\t3.5 /dataCatalogOutput - вывод данных каталога", "\t3.6 /dataProductOutput - вывод данных товара",
                "4. Изменение данных", "\t4.1 /changingWarehouseData - изменение данных склада",
                "\t4.2 /changingPointOfSaleData - изменение данных пункта продаж",
                "\t4.3 /changingEmployeeData - изменения данных сотрудника", "\t4.4 /changingBuyerData - изменение данных покупателя",
                "\t4.5 /changingCatalogData - изменение данных каталога", "\t4.6 /changingProductData - изменение данных товара",
                "\t4.7 /dismissal - увольнение сотрудника",
                "5. Проверка товара на налиие",
                "\t5.1 /checkingProductsForAvailabilityWarehouse - проверка товара на наличие на складе",
                "\t5.2 /checkingProductsForAvailabilityPointOfSale - проверка товара на наличие на пунтке продажи",
                "6. Передача товара", "\t6.1 /transferGoodsWarehouse - передача товара со склада", "\t6.2 /transferGoodsPointOfSale - передача товара с пункта продажи",
                "7. Закрытие", "\t7.1 /warehouseClosure - закрытие склада", "\t7.2 /pointOfSaleClosure - закрытие пункта продажи"};
        for (String stringOutput : introductionArray) {
            System.out.println(stringOutput);
        }
        enteringCommand();
    }

    public static void enteringCommand() {
        System.out.print("Команда: ");
        String command = scan.nextLine();
        switch (command) {
            case "/creatingWarehouse":
                creatingStorageLocation(true);
                break;
            case "/creatingPointOfSale":
                creatingStorageLocation(false);
                break;
            case "/addingEmployee":
                addingHuman(true);
                break;
            case "/addingBuyer":
                addingHuman(false);
                break;
            case "/addingCatalog" :
                addingProductCatalog();
                break;
            case "/addingProduct":
                addingProduct();
                break;
            case "/addingProductWarehouse":
                addingProducts(true);
                break;
            case "/addingProductPointOfSale":
                addingProducts(false);
                break;
            case "/dataWarehouseOutput":
                dataOutput(true);
                break;
            case "/dataPointOfSaleOutput":
                dataOutput(false);
                break;
            case "/dataEmployeeOutput":
                humanDataOutput(true);
                break;
            case "/dataBuyerOutput":
                humanDataOutput(false);
                break;
            case "/dataCatalogOutput":
                dataCatalogOutput();
                break;
            case "/dataProductOutput":
                dataProductOutput();
                break;
            case "/changingWarehouseData":
                changingData(true);
                break;
            case "/changingPointOfSaleData":
                changingData(false);
                break;
            case "/changingEmployeeData":
                changingHumanData(true);
                break;
            case "/changingBuyerData":
                changingHumanData(false);
                break;
            case "/changingCatalogData":
                addingProductCatalog();
                break;
            case "/changingProductData":
                addingProduct();
                break;
            case "/dismissal":
                dismissal();
                break;
            case "/checkingProductsForAvailabilityWarehouse":
                checkingProductsForAvailability(true);
                break;
            case "/checkingProductsForAvailabilityPointOfSale":
                checkingProductsForAvailability(false);
                break;
            case "/transferGoodsWarehouse":
                transferGoods(true);
                break;
            case "/transferGoodsPointOfSale":
                transferGoods(false);
                break;
            case "/warehouseClosure":
                closureEnterprise(true);
                break;
            case "/pointOfSaleClosure":
                closureEnterprise(false);
                break;
            default:
                System.out.println("Некорректная команда! Попробуйте ещё раз");
                enteringCommand();
        }
    }

    public static void creatingStorageLocation(boolean warehouseCond){
        System.out.print("Введите id: ");
        int id = scan.nextInt();
        System.out.print("Введите вместимость: ");
        int capacity = scan.nextInt();
        System.out.print("Введите id ответственного сотрудника: ");
        int idEmployee = scan.nextInt();
        scan.nextLine();
        System.out.print("Введите описание: ");
        String about = scan.nextLine();
        System.out.print("Введите адрес: ");
        String address = scan.nextLine();
        if (warehouseCond) {
            Warehouse warehouseCreating = new Warehouse(id, capacity,
                    idEmployee, about, address);
            warehouseArray[id] = warehouseCreating;
        } else {
            PointOfSale pointOfSaleCreating = new PointOfSale(id, capacity,
                    idEmployee, about, address);
            pointOfSaleArray[id] = pointOfSaleCreating;
        }
        enteringCommand();
    }

    public static void addingHuman(boolean condEmployee) {
        System.out.print("Введите id человека: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Введите ФИО: ");
        String fullName = scan.nextLine();
        System.out.print("Введите дату рождения: ");
        String dateOfBirth = scan.nextLine();
        System.out.print("Введите пол: ");
        String gender = scan.nextLine();
        if (condEmployee) {
            System.out.print("Введите должность: ");
            String jobTitle = scan.nextLine();
            System.out.print("Введите дату трудоустройства: ");
            String employmentDate = scan.nextLine();
            employeeArray[id] = new Employee(id, fullName, dateOfBirth, gender, jobTitle, employmentDate);
        } else {
            buyerArray[id] = new Buyer(id, fullName, dateOfBirth, gender);
        }
        enteringCommand();
    }

    public static void addingProducts(boolean warehouseCond){
        System.out.print("Введите id: ");
        int id = scan.nextInt();
        System.out.print("Введите количество добавляемого товара: ");
        int number = scan.nextInt();
        int[] slots = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.print("Введите id " + (i + 1) +  " позиции: ");
            slots[i] = scan.nextInt();
        }
        if (warehouseCond) {
            warehouseArray[id].content(number, slots);
        } else {
            pointOfSaleArray[id].content(number, slots);
        }
        scan.nextLine();
        enteringCommand();
    }

    public static void addingProductCatalog(){
        System.out.print("Введите id: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Введите название: ");
        String name = scan.nextLine();
        System.out.print("Введите размеры товара: ");
        String size = scan.nextLine();
        System.out.print("Введите цену закупки: ");
        int purchasePrice = scan.nextInt();
        scan.nextLine();
        System.out.print("Описание товара: ");
        String description = scan.nextLine();
        System.out.print("Введите дату окончания доставки товара: ");
        String deliveryDeadline = scan.nextLine();
        catalogArray[id] = new Catalog(id, name, size, purchasePrice, description, deliveryDeadline);
        enteringCommand();
    }

    public static void addingProduct(){
        System.out.print("Введите id: ");
        int id = scan.nextInt();
        System.out.print("Введите id из каталога: ");
        int idCatalog = scan.nextInt();
        String[] stringData = catalogArray[idCatalog].getStringData();
        System.out.print("Введите id ответственного лица: ");
        int idOfThePersonInChange = scan.nextInt();
        System.out.print("Введите цену продажи: ");
        double sellingPrice = scan.nextDouble();
        productArray[id] = new Product(id, stringData[0], stringData[1], catalogArray[idCatalog].getPurchasePrice(),
                stringData[2], stringData[3], idCatalog, idOfThePersonInChange, sellingPrice);
        scan.nextLine();
        enteringCommand();
    }

    public static void dataOutput(boolean condWarehouse) {
        System.out.print("Введите id склада: ");
        int id = scan.nextInt();
        if (condWarehouse) {
            warehouseArray[id].dataOutput(employeeArray);
        } else {
            pointOfSaleArray[id].dataOutput(employeeArray);
        }
        scan.nextLine();
        enteringCommand();
    }

    public static void humanDataOutput(boolean condEmployee) {
        System.out.print("Введите id: ");
        int id = scan.nextInt();
        if (condEmployee) {
            employeeArray[id].humanDataOutput();
        } else {
            buyerArray[id].humanDataOutput();
        }
        enteringCommand();
    }

    public static void dataCatalogOutput() {
        System.out.print("Введите id: ");
        int id = scan.nextInt();
        catalogArray[id].catalogDataOutput();
         enteringCommand();
    }

    public static void dataProductOutput(){
        System.out.print("Введите id: ");
        int id = scan.nextInt();
        productArray[id].productDataOutput();
        scan.nextLine();
        enteringCommand();
    }

    public static void changingData(boolean condWarehouse) {
        System.out.print("Введите id: ");
        int id = scan.nextInt();
        System.out.print("Введите вместимость: ");
        int capacity = scan.nextInt();
        System.out.print("Введите id ответственного сотрудника: ");
        int idEmployee = scan.nextInt();
        scan.next();
        System.out.print("Введите информацию: ");
        String about = scan.nextLine();
        if (condWarehouse) {
            warehouseArray[id].changeData(capacity, idEmployee, about);
        } else {
            pointOfSaleArray[id].changeData(capacity, idEmployee, about);
        }
        scan.nextLine();
        enteringCommand();
    }

    public static void changingHumanData(boolean condEmployee) {
        System.out.print("Введите id: ");
        int id = scan.nextInt();
        System.out.print("Введите ФИО: ");
        String fullName = scan.nextLine();
        System.out.print("Введите дату рождения: ");
        String dateOfBirth = scan.nextLine();
        System.out.print("Введите пол: ");
        String gender = scan.nextLine();
        if (condEmployee) {
            System.out.print("Введите должность: ");
            String jobTitle = scan.nextLine();
            System.out.print("Введите дату трудоустройства: ");
            String employmentDate = scan.nextLine();
            System.out.print("Введите дату увольнения: ");
            String dateOfDismissal = scan.nextLine();
            employeeArray[id] = new Employee(id, fullName, dateOfBirth, gender, jobTitle, employmentDate);
            employeeArray[id].setDateOfDismissal(dateOfDismissal);
        } else {
            System.out.println("Введите скидку: ");
            double discount = scan.nextDouble();
            buyerArray[id] = new Buyer(id, fullName, dateOfBirth, gender);
            buyerArray[id].setDiscount(discount);
        }
        scan.nextLine();
        enteringCommand();
    }

    public static void dismissal(){
        System.out.print("Введите id: ");
        int id = scan.nextInt();
        System.out.println("Введите дату увольнения: ");
        String dismissal = scan.nextLine();
        employeeArray[id].setDateOfDismissal(dismissal);
        scan.nextLine();
        enteringCommand();
    }

    public static void checkingProductsForAvailability(boolean condWarehouse) {
        System.out.print("Введите id предприятия: ");
        int id = scan.nextInt();
        System.out.print("Введите id товара: ");
        int idProduct = scan.nextInt();
        if (condWarehouse) {
            if (warehouseArray[id].checkProductAvailability(idProduct)) {
                System.out.println("Товар с id " + idProduct + " содержится на складе №" + id + ".");
            } else {
                System.out.println("Товар с id " + idProduct + " отсутствует на складе №" + id + ".");
            }
        } else {
            if (pointOfSaleArray[id].checkProductAvailability(idProduct)) {
                System.out.println("Товар с id " + idProduct + " содержится на пункте продажи №" + id + ".");
            } else {
                System.out.println("Товар с id " + idProduct + " отсутствует на пункте продажи №" + id + ".");
            }
        }
        scan.nextLine();
        enteringCommand();
    }

    public static void transferGoods(boolean condWarehouse) {
        System.out.print("Введите id предприятия с которого следует передать товар: ");
        int idFrom = scan.nextInt();
        System.out.print("Введите id предприятия на который следует передать товар: ");
        int idTo = scan.nextInt();
        System.out.print("Введите id товара: ");
        int idProduct = scan.nextInt();
        System.out.print("Введите позицию товара со склада, с которого требутеся взять товар: ");
        int idPosition = scan.nextInt() - 1;
        if (condWarehouse) {
            warehouseArray[idFrom].transferGoods(pointOfSaleArray[idTo], idProduct, idPosition);
        } else {
            pointOfSaleArray[idFrom].transferGoodsToWarehouse(warehouseArray[idTo], idProduct, idPosition);
        }
        scan.nextLine();
        enteringCommand();
    }

    public static void closureEnterprise(boolean condWarehouse) {
    System.out.println("Введите id предприятия: ");
    int id = scan.nextInt();
    if (condWarehouse) {
        warehouseArray[id].closeEnterprise();
    } else {
        pointOfSaleArray[id].closeEnterprise();
    }
    scan.nextLine();
    enteringCommand();
    }
}