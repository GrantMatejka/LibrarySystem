package edu.calpoly.csc365.entity;

public class   Inventory {
   private String bookId;
   private Integer totalQuantity;
   private Integer checkedOut; // Quantity of this book checked out

   public Inventory() {
      this.bookId = null;
      this.totalQuantity = null;
      this.checkedOut = null;
   }

   public Inventory(String bookId, Integer totalQuantity, Integer checkedOut) {
      this.bookId = bookId;
      this.totalQuantity = totalQuantity;
      this.checkedOut = checkedOut;
   }

   public String getBookId() {
      return this.bookId;
   }

   public void setBookId(String bookId) {
      this.bookId = bookId;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public void setTotalQuantity(Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public Integer getCheckedOut() {
      return this.checkedOut;
   }

   public void setCheckedOut(Integer checkedOut) {
      this.checkedOut = checkedOut;
   }

   public Inventory bookId(String bookId) {
      this.bookId = bookId;
      return this;
   }

   public Inventory totalQuantity(Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   public Inventory checkedOut(Integer checkedOut) {
      this.checkedOut = checkedOut;
      return this;
   }

   @Override
   public String toString() {
      return "{" +
         " bookId='" + getBookId() + "'" +
         ", totalQuantity='" + getTotalQuantity() + "'" +
         ", checkedOut='" + getCheckedOut() + "'" +
         "}";
   }

   
}