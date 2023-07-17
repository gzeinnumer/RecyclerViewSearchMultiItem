package com.gzeinnumer.recyclerviewsearchmultiitem;

import java.util.ArrayList;

//TODO tambah ini gzeinnumer
class DataItemV2 {
    String strTv1, strTv2;
    //['satu','dua','tiga']
    int index, idSpinner;
    boolean isCheck = false;
    ArrayList<String> spinners;

    public DataItemV2(int index, String strTv1, String strTv2, int idSpinner, ArrayList<String> spinners) {
        this.index = index;
        this.strTv1 = strTv1;
        this.strTv2 = strTv2;
        this.idSpinner = idSpinner;
        this.spinners = spinners;
    }

    public ArrayList<String> getSpinners() {
        return spinners;
    }

    public void setSpinners(ArrayList<String> spinners) {
        this.spinners = spinners;
    }

    public int getIdSpinner() {
        return idSpinner;
    }

    public void setIdSpinner(int idSpinner) {
        this.idSpinner = idSpinner;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    @Override
    public String toString() {
        return "DataItemV2{" +
                "strTv1='" + strTv1 + '\'' +
                ", strTv2='" + strTv2 + '\'' +
                ", index=" + index +
                ", idSpinner=" + idSpinner +
                ", isCheck=" + isCheck +
                ", spinners=" + spinners +
                '}';
    }
}
