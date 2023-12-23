package project;

public class Employee extends Human{
    private String jobTitle;
    private String dateOfDismissal;
    private String employmentDate;

    public Employee(int id, String fullName, String dateOfBirth, String gender,
                    String jobTitle, String employmentDate) {
        super(id, fullName, dateOfBirth, gender);
        this.jobTitle = jobTitle;
        this.employmentDate = employmentDate;
        this.dateOfDismissal = "";
    }

    public void setDateOfDismissal(String dateOfDismissal) {
        this.dateOfDismissal = dateOfDismissal;
    }

    @Override
    public void humanDataOutput() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Дата рождения: " + dateOfBirth);
        System.out.println("Пол: " + gender);
        System.out.println("Должность: " + jobTitle);
        System.out.println("Дата нанятия: " + employmentDate);
        System.out.println("Дата увольнения: " + dateOfDismissal);
    }
}
