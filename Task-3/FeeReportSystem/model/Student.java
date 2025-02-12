package model;

import java.text.DecimalFormat;

public class Student {
    private int id;
    private String name;
    private String email;
    private String course;
    private double fee;
    private double paid;
    private double due;
    private String address;
    private String phone;

  
    private static final DecimalFormat df = new DecimalFormat("0.00");


    public Student(int id, String name, String email, String course, double fee, double paid, double due, String address, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.fee = fee;
        this.paid = paid;
        this.due = due;
        this.address = address;
        this.phone = phone;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public double getFee() { return fee; }
    public double getPaid() { return paid; }
    public double getDue() { return due; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setCourse(String course) { this.course = course; }
    public void setFee(double fee) { this.fee = fee; }
    public void setPaid(double paid) { this.paid = paid; }
    public void setDue(double due) { this.due = due; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }

   
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email + ", Course: " + course +
               ", Fee: " + df.format(fee) + ", Paid: " + df.format(paid) + ", Due: " + df.format(due) +
               ", Address: " + address + ", Phone: " + phone;
    }
}
