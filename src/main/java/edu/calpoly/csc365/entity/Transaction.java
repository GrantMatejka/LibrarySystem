package edu.calpoly.csc365.entity;

import java.sql.Date;

public class Transaction {
   private Integer id;
   private String bookId;
   private Integer copyNum;    // What copy is this book? (ex: transaction 5 for book 3 copy 2)
   private Integer userId;
   private Date checkOutDate;
   private Date expectedCheckInDate;
   private Boolean extend;


   public Transaction() {
      this.id = null;
      this.bookId = null;
      this.copyNum = null;
      this.userId = null;
      this.checkOutDate = null;
      this.expectedCheckInDate = null;
      this.extend = null;
   }

   // Constructor w/o id
   public Transaction(Integer bookId, Integer copyNum, Integer userId, Date checkOutDate, Date expectedCheckInDate, Boolean extend) {
      this.id = null;
      this.bookId = bookId;
      this.copyNum = copyNum;
      this.userId = userId;
      this.checkOutDate = checkOutDate;
      this.expectedCheckInDate = expectedCheckInDate;
      this.extend = extend;
   }

   // Constructor w/ id
   public Transaction(Integer id, Integer bookId, Integer copyNum, Integer userId, Date checkOutDate, Date expectedCheckInDate, Boolean extend) {
      this.id = id;
      this.bookId = bookId;
      this.copyNum = copyNum;
      this.userId = userId;
      this.checkOutDate = checkOutDate;
      this.expectedCheckInDate = expectedCheckInDate;
      this.extend = extend;
   }

   public Integer getId() {
      return this.id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getBookId() {
      return this.bookId;
   }

   public void setBookId(Integer bookId) {
      this.bookId = bookId;
   }

   public Integer getCopyNum() {
      return this.copyNum;
   }

   public void setCopyNum(Integer copyNum) {
      this.copyNum = copyNum;
   }

   public Integer getUserId() {
      return this.userId;
   }

   public void setUserId(Integer userId) {
      this.userId = userId;
   }

   public Date getCheckOutDate() {
      return this.checkOutDate;
   }

   public void setCheckOutDate(Date checkOutDate) {
      this.checkOutDate = checkOutDate;
   }

   public Date getExpectedCheckInDate() {
      return this.expectedCheckInDate;
   }

   public void setExpectedCheckInDate(Date expectedCheckInDate) {
      this.expectedCheckInDate = expectedCheckInDate;
   }

   public Boolean isExtend() {
      return this.extend;
   }

   public Boolean getExtend() {
      return this.extend;
   }

   public void setExtend(Boolean extend) {
      this.extend = extend;
   }

   public Transaction id(Integer id) {
      this.id = id;
      return this;
   }

   public Transaction bookId(Integer bookId) {
      this.bookId = bookId;
      return this;
   }

   public Transaction copyNum(Integer copyNum) {
      this.copyNum = copyNum;
      return this;
   }

   public Transaction userId(Integer userId) {
      this.userId = userId;
      return this;
   }

   public Transaction checkOutDate(Date checkOutDate) {
      this.checkOutDate = checkOutDate;
      return this;
   }

   public Transaction expectedCheckInDate(Date expectedCheckInDate) {
      this.expectedCheckInDate = expectedCheckInDate;
      return this;
   }

   public Transaction extend(Boolean extend) {
      this.extend = extend;
      return this;
   }

   @Override
   public String toString() {
      return "{" +
         " id='" + getId() + "'" +
         ", bookId='" + getBookId() + "'" +
         ", copyNum='" + getCopyNum() + "'" +
         ", userId='" + getUserId() + "'" +
         ", checkOutDate='" + getCheckOutDate() + "'" +
         ", expectedCheckInDate='" + getExpectedCheckInDate() + "'" +
         ", extend='" + isExtend() + "'" +
         "}";
   }


}
