package project;

abstract class Human {
    protected int id;
    protected String fullName;
    protected String dateOfBirth;
    protected String gender;

    protected Human(int id, String fullName, String dateOfBirth, String gender) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    protected abstract void humanDataOutput();
}