package com.inphynous.futuresupport8x;

public class Detail4 {
    int loan_amt,month2,interest,return_amt_1,remain_amt,return_amt_2,return_amt_3;
    String ondate,uptodate,date1,date2,date3;

    public int getReturn_amt_1() {
        return return_amt_1;
    }

    public void setReturn_amt_1(int return_amt_1) {
        this.return_amt_1 = return_amt_1;
    }

    public int getReturn_amt_2() {
        return return_amt_2;
    }

    public void setReturn_amt_2(int return_amt_2) {
        this.return_amt_2 = return_amt_2;
    }

    public int getReturn_amt_3() {
        return return_amt_3;
    }

    public void setReturn_amt_3(int return_amt_3) {
        this.return_amt_3 = return_amt_3;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getDate3() {
        return date3;
    }

    public void setDate3(String date3) {
        this.date3 = date3;
    }

    public Detail4(int loan_amt, String ondate, int month2, int interest, int return_amt_1, int remain_amt, String uptodate, int return_amt_2, int return_amt_3, String date1, String date2, String date3) {

        this.loan_amt= loan_amt;
        this.month2 = month2;
        this.interest= interest;
        this.return_amt_1=return_amt_1;
        this.return_amt_2=return_amt_2;
        this.return_amt_3=return_amt_3;
        this.remain_amt=remain_amt;
        this.ondate=ondate;
        this.uptodate= uptodate;
        this.date1=date1;
        this.date2=date2;
        this.date3=date3;

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


    public int getRemain_amt() {
        return remain_amt;
    }

    public void setRemain_amt(int remain_amt) {
        this.remain_amt = remain_amt;
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
}
