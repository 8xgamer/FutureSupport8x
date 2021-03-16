package com.inphynous.futuresupport8x;

public class Employee {
    private String id,username,password1,fullname,mobileno,email;
    boolean status;
    private int invested_amount;
    private int current_amount;

    public Employee() {

    }

    public Employee(String id, String fullname, String username, String password1, String mobileno, String email,boolean status, int invested_amount,int current_amount) {
        this.id = id;
        this.username = username;
        this.password1 = password1;
        this.fullname = fullname;
        this.mobileno = mobileno;
        this.email = email;
        this.status = status;
        this.invested_amount= invested_amount;
        this.current_amount= current_amount;

    }

    public int getCurrent_amount() {
        return current_amount;
    }

    public void setCurrent_amount(int current_amount) {
        this.current_amount = current_amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobileno() {
        return mobileno;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getInvested_amount() {
        return invested_amount;
    }

    public void setInvested_amount(int invested_amount) {
        this.invested_amount = invested_amount;
    }
}
