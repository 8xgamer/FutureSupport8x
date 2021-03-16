package com.inphynous.futuresupport8x;

public class Detail {


    int loan;
    String accountno;
    String ifsc;
    String bankname;
    String username;
    boolean status;
    String ondate;
    String uptodate;
    int investedamt;
    int currentamt;


    public Detail(boolean status, int loan, String accountno, String ifsc, String bankname, String username, String ondate, String uptodate,    int investedamt,int currentamt) {
        this.status = status;
        this.loan = loan;
        this.ondate = ondate;
        this.uptodate = uptodate;
        this.accountno = accountno;
        this.ifsc = ifsc;
        this.bankname = bankname;
        this.username = username;
        this.investedamt = investedamt;
        this.currentamt = currentamt;

    }

    public String getUsername() {
        return username;
    }

    public int getInvestedamt() {
        return investedamt;
    }

    public void setInvestedamt(int investedamt) {
        this.investedamt = investedamt;
    }

    public int getCurrentamt() {
        return currentamt;
    }

    public void setCurrentamt(int currentamt) {
        this.currentamt = currentamt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOndate() {
        return ondate;
    }

    public void setOndate(String ondate) {
        this.ondate = ondate;
    }

    public String getUptodate() {
        return uptodate;
    }

    public void setUptodate(String uptodate) {
        this.uptodate = uptodate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getLoan() {
        return loan;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

}
