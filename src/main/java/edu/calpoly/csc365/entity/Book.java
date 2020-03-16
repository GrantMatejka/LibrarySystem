package edu.calpoly.csc365.entity;

public class Book {
   private String asin;
   private Integer copyNum;
   private String filename;
   private String imageUrl;
   private String title;
   private Integer categoryId; 
   private String category;

   public Book() {
      this.asin = null;
      this.copyNum = null;
      this.filename = null;
      this.imageUrl = null;
      this.title = null;
      this.categoryId = null;
      this.category = null;
   }

   public Book(String asin, Integer copyNum, String filename, String imageUrl, String title, Integer categoryId, String category) {
      this.asin = asin;
      this.copyNum = copyNum;
      this.filename = filename;
      this.imageUrl = imageUrl;
      this.title = title;
      this.categoryId = categoryId;
      this.category = category;
   }

   public String getAsin() {
      return this.asin;
   }

   public void setAsin(String asin) {
      this.asin = asin;
   }

   public Integer getCopyNum() {
      return this.copyNum;
   }

   public void setCopyNum(Integer copyNum) {
      this.copyNum = copyNum;
   }

   public String getFilename() {
      return this.filename;
   }

   public void setFilename(String filename) {
      this.filename = filename;
   }

   public String getImageUrl() {
      return this.imageUrl;
   }

   public void setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
   }

   public String getTitle() {
      return this.title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public Integer getCategoryId() {
      return this.categoryId;
   }

   public void setCategoryId(Integer categoryId) {
      this.categoryId = categoryId;
   }

   public String getCategory() {
      return this.category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public Book asin(String asin) {
      this.asin = asin;
      return this;
   }

   public Book copyNum(Integer copyNum) {
      this.copyNum = copyNum;
      return this;
   }

   public Book filename(String filename) {
      this.filename = filename;
      return this;
   }

   public Book imageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
      return this;
   }

   public Book title(String title) {
      this.title = title;
      return this;
   }

   public Book categoryId(Integer categoryId) {
      this.categoryId = categoryId;
      return this;
   }

   public Book category(String category) {
      this.category = category;
      return this;
   }

   @Override
   public String toString() {
      return "{" +
         " asin='" + getAsin() + "'" +
         ", copyNum='" + getCopyNum() + "'" +
         ", filename='" + getFilename() + "'" +
         ", imageUrl='" + getImageUrl() + "'" +
         ", title='" + getTitle() + "'" +
         ", categoryId='" + getCategoryId() + "'" +
         ", category='" + getCategory() + "'" +
         "}";
   }


}