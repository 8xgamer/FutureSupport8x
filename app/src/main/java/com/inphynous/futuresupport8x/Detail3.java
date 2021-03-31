package com.inphynous.futuresupport8x;

public class Detail3 {

    int loan_amt,month2,interest,return_amt,A1;
    String ondate;
    public Detail3(int loan_amt, String ondate, int month2, int interest, int return_amt, int A1) {
        super();
        this.loan_amt = loan_amt;
        this.ondate = ondate;
        this.month2 = month2;
        this.interest = interest;
        this.return_amt = return_amt;
        this.A1 = A1;

    }

    public int getLoan_amt() {
        return loan_amt;
    }

    public void setLoan_amt(int loan_amt) {
        this.loan_amt = loan_amt;
    }

    public int getMonth2() {
        return month2;
    }

    public void setMonth2(int month2) {
        this.month2 = month2;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public int getReturn_amt() {
        return return_amt;
    }

    public void setReturn_amt(int return_amt) {
        this.return_amt = return_amt;
    }

    public int getA1() {
        return A1;
    }

    public void setA1(int a1) {
        A1 = a1;
    }

    public String getOndate() {
        return ondate;
    }

    public void setOndate(String ondate) {
        this.ondate = ondate;
    }
}
