package edu.calpoly.csc365.entity;

import java.sql.Date;

public class Reservation {
   private Integer id;
   private Date dateReserved;
   private Integer userId;
   private String bookId;
   private Boolean fullfilled;


   public Reservation() {
      this.id = null;
      this.dateReserved = null;
      this.userId = null;
      this.bookId = null;
      this.fullfilled = null;
   }

   public Reservation(Date dateReserved, Integer userId, String bookId, Boolean fullfilled) {
      this.id = null;
      this.dateReserved = dateReserved;
      this.userId = userId;
      this.bookId = bookId;
      this.fullfilled = fullfilled;
   }

   public Reservation(Integer id, Date dateReserved, Integer userId, String bookId, Boolean fullfilled) {
      this.id = id;
      this.dateReserved = dateReserved;
      this.userId = userId;
      this.bookId = bookId;
      this.fullfilled = fullfilled;
   }

   public Integer getId() {
      return this.id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Date getDateReserved() {
      return this.dateReserved;
   }

   public void setDateReserved(Date dateReserved) {
      this.dateReserved = dateReserved;
   }

   public Integer getUserId() {
      return this.userId;
   }

   public void setUserId(Integer userId) {
      this.userId = userId;
   }

   public String getBookId() {
      return this.bookId;
   }

   public void setBookId(String bookId) {
      this.bookId = bookId;
   }

   public Boolean isFullfilled() {
      return this.fullfilled;
   }

   public Boolean getFullfilled() {
      return this.fullfilled;
   }

   public void setFullfilled(Boolean fullfilled) {
      this.fullfilled = fullfilled;
   }

   public Reservation id(Integer id) {
      this.id = id;
      return this;
   }

   public Reservation dateReserved(Date dateReserved) {
      this.dateReserved = dateReserved;
      return this;
   }

   public Reservation userId(Integer userId) {
      this.userId = userId;
      return this;
   }

   public Reservation bookId(String bookId) {
      this.bookId = bookId;
      return this;
   }

   public Reservation fullfilled(Boolean fullfilled) {
      this.fullfilled = fullfilled;
      return this;
   }

   @Override
   public String toString() {
      return "{" +
         " id='" + getId() + "'" +
         ", dateReserved='" + getDateReserved() + "'" +
         ", userId='" + getUserId() + "'" +
         ", bookId='" + getBookId() + "'" +
         ", fullfilled='" + isFullfilled() + "'" +
         "}";
   }

}