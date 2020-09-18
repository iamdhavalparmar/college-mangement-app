package com.example.dhaval.project.model;

public class PlacementDetails {


     /* Initialisation */

  private String company_id = null;
  private String user_id = "";
  private String compnay_name = "";
  private String logo = "";

     /* Setter */

  public void setCompany_id(String company_id) {
     this.company_id = company_id;
  }

  public void setUser_id(String user_id) {
     this.user_id = user_id;
  }

  public void setCompnay_name(String compnay_name) {
     this.compnay_name = compnay_name;
  }

  public void setLogo(String logo) {
     this.logo = logo;
  }

     /* Get table name */
  public static String getTableName() {
    return "placement_details";
  }

     /* Getter */

  public String getCompany_id() {
    return company_id;
  }

  public String getUser_id() {
    return user_id;
  }

  public String getCompnay_name() {
    return compnay_name;
  }

  public String getLogo() {
    return logo;
  }

     /* Table Name String */

   public class s {
       public static final String company_id = "company_id";
       public static final String user_id = "user_id";
       public static final String compnay_name = "compnay_name";
       public static final String logo = "logo";
   }

}
