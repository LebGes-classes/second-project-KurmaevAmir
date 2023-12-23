package project;

public class Buyer extends Human{
    private int id;
    private double discount;

    public Buyer(int id, String fullName, String dateOfBirth, String gender) {
        super(id, fullName, dateOfBirth, gender);
        this.discount = 0;
    }

    @Override
    public void humanDataOutput() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Дата рождения: " + dateOfBirth);
        System.out.println("Пол: " + gender);
        System.out.println("Скидка: " + discount);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}