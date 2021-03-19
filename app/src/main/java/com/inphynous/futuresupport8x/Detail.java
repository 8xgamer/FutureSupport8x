package com.inphynous.futuresupport8x;

public class Detail {


    int loan;
    String accountno,month_date;
    String ifsc;
    String bankname;
    String username;
    boolean status;
    String ondate;
    String uptodate;
    int investedamt;
    int currentamt;
    int a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,sum;
    String date1,date2,date3,date4,date5,date6,date7,date8,date9,date10,date11,date12;


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

    public String getMonth_date() {
        return month_date;
    }

    public void setMonth_date(String month_date) {
        this.month_date = month_date;
    }

    public int getA1() {
        return a1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public int getA2() {
        return a2;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }

    public int getA3() {
        return a3;
    }

    public void setA3(int a3) {
        this.a3 = a3;
    }

    public int getA4() {
        return a4;
    }

    public void setA4(int a4) {
        this.a4 = a4;
    }

    public int getA5() {
        return a5;
    }

    public void setA5(int a5) {
        this.a5 = a5;
    }

    public int getA6() {
        return a6;
    }

    public void setA6(int a6) {
        this.a6 = a6;
    }

    public int getA7() {
        return a7;
    }

    public void setA7(int a7) {
        this.a7 = a7;
    }

    public int getA8() {
        return a8;
    }

    public void setA8(int a8) {
        this.a8 = a8;
    }

    public int getA9() {
        return a9;
    }

    public void setA9(int a9) {
        this.a9 = a9;
    }

    public int getA10() {
        return a10;
    }

    public void setA10(int a10) {
        this.a10 = a10;
    }

    public int getA11() {
        return a11;
    }

    public void setA11(int a11) {
        this.a11 = a11;
    }

    public int getA12() {
        return a12;
    }

    public void setA12(int a12) {
        this.a12 = a12;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
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

    public String getDate4() {
        return date4;
    }

    public void setDate4(String date4) {
        this.date4 = date4;
    }

    public String getDate5() {
        return date5;
    }

    public void setDate5(String date5) {
        this.date5 = date5;
    }

    public String getDate6() {
        return date6;
    }

    public void setDate6(String date6) {
        this.date6 = date6;
    }

    public String getDate7() {
        return date7;
    }

    public void setDate7(String date7) {
        this.date7 = date7;
    }

    public String getDate8() {
        return date8;
    }

    public void setDate8(String date8) {
        this.date8 = date8;
    }

    public String getDate9() {
        return date9;
    }

    public void setDate9(String date9) {
        this.date9 = date9;
    }

    public String getDate10() {
        return date10;
    }

    public void setDate10(String date10) {
        this.date10 = date10;
    }

    public String getDate11() {
        return date11;
    }

    public void setDate11(String date11) {
        this.date11 = date11;
    }

    public String getDate12() {
        return date12;
    }

    public void setDate12(String date12) {
        this.date12 = date12;
    }

    public Detail(String month_date, int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, String date1, String date2, String date3, String date4, String date5, String date6, String date7, String date8, String date9, String date10, String date11, String date12, int total_sum) {
        this.month_date = month_date;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
        this.a6 = a6;
        this.a7 = a7;
        this.a8 = a8;
        this.a9 = a9;
        this.a10 = a10;
        this.a11 = a11;
        this.a12 = a12;
        this.date1 = date1;
        this.date2 = date2;
        this.date3 = date3;
        this.date4 = date4;
        this.date5 = date5;
        this.date6 = date6;
        this.date7 = date7;
        this.date8 = date8;
        this.date9 = date9;
        this.date10 = date10;
        this.date11 = date11;
        this.date12 = date12;
        this.sum = total_sum;

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
