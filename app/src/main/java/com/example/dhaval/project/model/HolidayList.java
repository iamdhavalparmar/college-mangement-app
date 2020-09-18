package com.example.dhaval.project.model;

public class HolidayList {


     /* Initialisation */

  private String user_id = null;
  private String date = "";
  private String description = "";

     /* Setter */

  public void setUser_id(String user_id) {
     this.user_id = user_id;
  }

  public void setDate(String date) {
     this.date = date;
  }

  public void setDescription(String description) {
     this.description = description;
  }

     /* Get table name */
  public static String getTableName() {
    return "holiday_list";
  }

     /* Getter */

  public String getUser_id() {
    return user_id;
  }

  public String getDate() {
    return date;
  }

  public String getDescription() {
    return description;
  }

     /* Table Name String */

   public class s {
       public static final String user_id = "user_id";
       public static final String date = "date";
       public static final String description = "description";
   }

}
