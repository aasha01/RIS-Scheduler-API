package com.devskrol.appointment.model;

public class Patient {
    private String firstName; private String lastName;
    private String gender; private String dateOfBirth;
    // ISO date string
    private String phone;
    private String email;
    private String address;
    // Getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName)
    { this.firstName = firstName; }
    public String getLastName()
    { return lastName; }
    public void setLastName(String lastName)
    { this.lastName = lastName; } public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth)
    { this.dateOfBirth = dateOfBirth; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address)
    {
        this.address = address;
    }

}