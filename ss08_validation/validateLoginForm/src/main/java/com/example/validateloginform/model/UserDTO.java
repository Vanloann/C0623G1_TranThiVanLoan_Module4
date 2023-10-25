package com.example.validateloginform.model;

import javax.validation.constraints.*;

public class UserDTO {

    @NotEmpty(message = "Enter your first name")
    @Size(min = 5, max = 45)
    private String firstName;

    @NotEmpty(message = "Enter your last name")
    @Size(min = 5, max = 45)
    private String lastName;


    @Pattern(regexp = "^(((\\+84|84|0|0084){1})(3|5|7|8|9))+([0-9]{8})$")
    private String phoneNumber;

    @Min(18)
    private int age;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$")
    private String email;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,10}$")
    private String password;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String phoneNumber, int age, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
