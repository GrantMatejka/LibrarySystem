package edu.calpoly.csc365.entity;

public class Permission {
   private String permissionLevel;
   private Integer checkoutPeriod;


   public Permission() {      
      this.permissionLevel = null;
      this.checkoutPeriod = null;
   }

   public Permission(String permissionLevel, Integer checkoutPeriod) {
      this.permissionLevel = permissionLevel;
      this.checkoutPeriod = checkoutPeriod;
   }

   public String getPermissionLevel() {
      return this.permissionLevel;
   }

   public void setPermissionLevel(String permissionLevel) {
      this.permissionLevel = permissionLevel;
   }

   public Integer getCheckoutPeriod() {
      return this.checkoutPeriod;
   }

   public void setCheckoutPeriod(Integer checkoutPeriod) {
      this.checkoutPeriod = checkoutPeriod;
   }

   public Permission permissionLevel(String permissionLevel) {
      this.permissionLevel = permissionLevel;
      return this;
   }

   public Permission checkoutPeriod(Integer checkoutPeriod) {
      this.checkoutPeriod = checkoutPeriod;
      return this;
   }

   @Override
   public String toString() {
      return "{" +
         " permissionLevel='" + getPermissionLevel() + "'" +
         ", checkoutPeriod='" + getCheckoutPeriod() + "'" +
         "}";
   }

}