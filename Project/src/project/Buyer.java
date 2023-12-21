package project;

public class Buyer extends Human{
    private int id;
    private double discount;
    private String fullName;
    private String dateOfBirthday;
    private String gender;
    public Buyer(String fullName, String dateOfBirthday, String gender,
                 int id, double discount) {
        super(fullName, dateOfBirthday, gender);
        this.id = id;
        this.discount = discount;
    }
}