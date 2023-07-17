package com.gzeinnumer.recyclerviewsearchmultiitem;

import java.util.ArrayList;

class DataItem {
    String strTv1, strTv2;
    //TODO tambah ini gzeinnumer
    int realIndex, spinnerIndex;
    boolean isCheck = false;
    ArrayList<String> spinners;

    //TODO tambah ini gzeinnumer
    public DataItem(int index, String strTv1, String strTv2, int spinner, ArrayList<String> spinners) {
        this.realIndex = index;
        this.strTv1 = strTv1;
        this.strTv2 = strTv2;
        this.spinnerIndex = spinner;
        this.spinners = spinners;
    }

    public ArrayList<String> getSpinners() {
        return spinners;
    }

    public void setSpinners(ArrayList<String> spinners) {
        this.spinners = spinners;
    }

    public int getSpinnerIndex() {
        return spinnerIndex;
    }

    public void setSpinnerIndex(int spinnerIndex) {
        this.spinnerIndex = spinnerIndex;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public int getRealIndex() {
        return realIndex;
    }

    public void setRealIndex(int realIndex) {
        this.realIndex = realIndex;
    }

    public String getStrTv1() {
        return strTv1;
    }

    public void setStrTv1(String strTv1) {
        this.strTv1 = strTv1;
    }

    public String getStrTv2() {
        return strTv2;
    }

    public void setStrTv2(String strTv2) {
        this.strTv2 = strTv2;
    }
}
