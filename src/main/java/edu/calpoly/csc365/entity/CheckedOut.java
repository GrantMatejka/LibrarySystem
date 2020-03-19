package edu.calpoly.csc365.entity;

public class CheckedOut {
    private String asin;
    private String title;
    private Integer totalQuantity;
    private Integer checkedOut;

    public CheckedOut() {
        this.asin = null;
        this.title = null;
        this.totalQuantity = null;
        this.checkedOut = null;

    }

    public CheckedOut(String asin, String title, Integer totalQuantity, Integer checkedOut) {
        this.asin = asin;
        this.title = title;
        this.totalQuantity = totalQuantity;
        this.checkedOut = checkedOut;
    }

    public String getASIN() {
        return this.asin;
    }

    public void setASIN(String ASIN) {
        this.asin = ASIN;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalQuantity() {
        return this.totalQuantity;
    }

    public void setTotalQuantity(Integer totalquan) {
        this.totalQuantity = totalquan;
    }

    public Integer getCheckedOut() {
        return this.checkedOut;
    }

    public void setCheckedout(Integer checkedOut) {
        this.checkedOut = checkedOut;
    }

    public CheckedOut asin(String asin) {
        this.asin = asin;
        return this;
    }

    public CheckedOut title(String title) {
        this.title = title;
        return this;
    }

    public CheckedOut totalQuantity(Integer totalQuantity) {
    this.totalQuantity = totalQuantity;
    return this;
}
    public CheckedOut checkedOut(Integer checkedOut){
        this.checkedOut = checkedOut;
        return this;
    }


    public String toString(){
        return "{" +
                "asin ='" + getASIN() + "'," +
                "title = '" + getTitle() + "'," +
                "totalQuanitity = '" + getTotalQuantity() + "',"  +
                "checkedOut = '" + getCheckedOut() + "'}";
    }


    }
