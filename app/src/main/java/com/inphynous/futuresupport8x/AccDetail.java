package com.inphynous.futuresupport8x;

public class AccDetail {
    int total_deposite;
    int total_saving_with_interest;
    int available_amt_in_acc;
    int withdrawable_amt;
    int total_interest;
    int loan_disbursed_qt;
    int busy_amt_in_current_year;
    int date;
    int backup_amount;

    public AccDetail(int total_saving_with_interest, int backup_amount, int date, int i, int i1, int i2, int loan_disbursed_qty, int date1) {
        this.total_deposite = total_deposite;
        this.total_saving_with_interest = total_saving_with_interest;
        this.available_amt_in_acc = available_amt_in_acc;
        this.withdrawable_amt = withdrawable_amt;
        this.total_interest = total_interest;
        this.loan_disbursed_qt = loan_disbursed_qt;
        this.busy_amt_in_current_year = busy_amt_in_current_year;
        this.date = this.date;
        this.backup_amount = backup_amount;

    }

    public AccDetail(int total_deposited_amt, int busy_amount, int backup_amount, int i, int i1, int i2, int loan_disbursed_qty) {


    }

    public int getTotal_deposite() {
        return total_deposite;
    }

    public void setTotal_deposite(int total_deposite) {
        this.total_deposite = total_deposite;
    }
    public int getBackup_amount() {
        return backup_amount;
    }

    public void setBackup_amount(int backup_amount) {
        this.backup_amount = backup_amount;
    }

    public int getTotal_saving_with_interest() {
        return total_saving_with_interest;
    }

    public void setTotal_saving_with_interest(int total_saving_with_interest) {
        this.total_saving_with_interest = total_saving_with_interest;
    }

    public int getAvailable_amt_in_acc() {
        return available_amt_in_acc;
    }

    public void setAvailable_amt_in_acc(int available_amt_in_acc) {
        this.available_amt_in_acc = available_amt_in_acc;
    }

    public int getWithdrawable_amt() {
        return withdrawable_amt;
    }

    public void setWithdrawable_amt(int withdrawable_amt) {
        this.withdrawable_amt = withdrawable_amt;
    }

    public int getTotal_interest() {
        return total_interest;
    }

    public void setTotal_interest(int total_interest) {
        this.total_interest = total_interest;
    }

    public int getLoan_disbursed_qt() {
        return loan_disbursed_qt;
    }

    public void setLoan_disbursed_qt(int loan_disbursed_qt) {
        this.loan_disbursed_qt = loan_disbursed_qt;
    }
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getBusy_amt_in_current_year() {
        return busy_amt_in_current_year;
    }

   public void setBusy_amt_in_current_year(int busy_amt_in_current_year) {
        this.busy_amt_in_current_year = busy_amt_in_current_year;
    }
}
