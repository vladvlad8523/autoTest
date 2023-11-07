package org.example;

public class UserData {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String nameOther;

    public UserData(Integer id, String email, String firstName, String lastName, String nameOther) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nameOther = nameOther;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNameOther() {
        return nameOther;
    }
}
