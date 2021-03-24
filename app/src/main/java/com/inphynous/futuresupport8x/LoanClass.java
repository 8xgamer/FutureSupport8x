package com.inphynous.futuresupport8x;

public class LoanClass {
    private int sr_no;
    private String name;
    private int loan_amt;
    private String date_of_sanction;
    private String no_on_month;
    private String status_loan;

    LoanClass(int sr_no, String name,int loan_amt,String date_of_sanction,String no_on_month,String status_loan){
        this.sr_no=sr_no;
        this.name=name;
        this.loan_amt=loan_amt;
        this.date_of_sanction=date_of_sanction;
        this.no_on_month=no_on_month;
        this.status_loan=status_loan;

    }

    public String getStatus_loan() {
        return status_loan;
    }

    public void setStatus_loan(String status_loan) {
        this.status_loan = status_loan;
    }

    public void setSr_no(int sr_no) {
        this.sr_no = sr_no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoan_amt(int loan_amt) {
        this.loan_amt = loan_amt;
    }

    public void setDate_of_sanction(String date_of_sanction) {
        this.date_of_sanction = date_of_sanction;
    }

    public void setNo_on_month(String no_on_month) {
        this.no_on_month = no_on_month;
    }

    public int getSr_no() {
        return sr_no;
    }

    public String getName() {
        return name;
    }

    public int getLoan_amt() {
        return loan_amt;
    }

    public String getDate_of_sanction() {
        return date_of_sanction;
    }

    public String getNo_on_month() {
        return no_on_month;
    }

}
