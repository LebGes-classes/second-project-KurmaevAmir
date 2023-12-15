package project;

public class Employee extends Human{
    private String jobTitle;
    private String dateOfDismissal;
    private String employmentDate;
    private String fullName;
    private String dateOfBirthday;
    private String gender;

    public Employee(String jobTitle, String dateOfDismissal, String employmentDate,
                    String fullName, String dateOfBirthday, String gender){
        super(fullName, dateOfBirthday, gender);
        this.jobTitle = jobTitle;
        this.dateOfDismissal = dateOfDismissal;
        this.employmentDate = employmentDate;
    }

}
