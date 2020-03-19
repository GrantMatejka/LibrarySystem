package edu.calpoly.csc365.entity;

import java.sql.Date;

public class CheckedOut {
    private String asin;
    private String title;
    private Integer userId;
    private Date checkOutDate;
    private Date expectedCheckInDate;


    public CheckedOut() {
        this.asin = null;
        this.title = null;
        this.userId = null;
        this.checkOutDate = null;
        this.expectedCheckInDate = null;

    }

    public CheckedOut(String asin, String title,  Integer userId, Date checkOutDate, Date expectedCheckInDate) {
        this.asin = asin;
        this.title = title;
        this.userId = userId;
        this.checkOutDate = checkOutDate;
        this.expectedCheckInDate = expectedCheckInDate;

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


    public Integer getuserId(){
        return this.userId;
    }
    public void setuserId(Integer userId){
        this.userId = userId;
    }
    public Date getcheckOutDate(){
        return this.checkOutDate;
    }
    public void setcheckOutDate(Date d){
        this.checkOutDate = d;
    }

    public Date getexpectedCheckInDate(){
        return this.expectedCheckInDate;
    }
    public void setexpectedCheckInDate(Date d){
        this.expectedCheckInDate = d;
    }


    public CheckedOut asin(String asin) {
        this.asin = asin;
        return this;
    }

    public CheckedOut title(String title) {
        this.title = title;
        return this;
    }


    public String toString(){
        return "{" +
                "asin ='" + getASIN() + "'," +
                "title = '" + getTitle() + "'," +
                "userId = '" + getuserId() + "'," +
                "checkOutDate = '" + getcheckOutDate() + "',"  +
                "expectedCheckInDate = '" + getexpectedCheckInDate() + "'}";
    }


    }
