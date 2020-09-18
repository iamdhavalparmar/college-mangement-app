package com.example.dhaval.project.model;

public class Leave {


     /* Initialisation */

  private String leave_id = null;
  private String user_id = "";
  private String date = "";
  private String description = "";
  private String status = "";
  private String user_type = "";

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    /* Setter */

  public void setLeave_id(String leave_id) {
     this.leave_id = leave_id;
  }

  public void setUser_id(String user_id) {
     this.user_id = user_id;
  }

  public void setDate(String date) {
     this.date = date;
  }

  public void setDescription(String description) {
     this.description = description;
  }

  public void setStatus(String status) {
     this.status = status;
  }

     /* Get table name */
  public static String getTableName() {
    return "leave";
  }

     /* Getter */

  public String getLeave_id() {
    return leave_id;
  }

  public String getUser_id() {
    return user_id;
  }

  public String getDate() {
    return date;
  }

  public String getDescription() {
    return description;
  }

  public String getStatus() {
    return status;
  }

     /* Table Name String */

   public class s {
       public static final String leave_id = "leave_id";
       public static final String user_id = "user_id";
       public static final String date = "date";
       public static final String description = "description";
       public static final String status = "status";
   }

}
