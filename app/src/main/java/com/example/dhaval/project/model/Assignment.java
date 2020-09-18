package com.example.dhaval.project.model;

public class Assignment {


     /* Initialisation */

  private String assi_id = null;
  private String assi_desc = "";
  private String sem = "";
  private String assi_file = "";
  private String status = "";
  private String user_id = "";
  private String tt_id = "";

     /* Setter */

  public void setAssi_id(String assi_id) {
     this.assi_id = assi_id;
  }

  public void setAssi_desc(String assi_desc) {
     this.assi_desc = assi_desc;
  }

  public void setSem(String sem) {
     this.sem = sem;
  }

  public void setAssi_file(String assi_file) {
     this.assi_file = assi_file;
  }

  public void setStatus(String status) {
     this.status = status;
  }

  public void setUser_id(String user_id) {
     this.user_id = user_id;
  }

  public void setTt_id(String tt_id) {
     this.tt_id = tt_id;
  }

     /* Get table name */
  public static String getTableName() {
    return "assignment";
  }

     /* Getter */

  public String getAssi_id() {
    return assi_id;
  }

  public String getAssi_desc() {
    return assi_desc;
  }

  public String getSem() {
    return sem;
  }

  public String getAssi_file() {
    return assi_file;
  }

  public String getStatus() {
    return status;
  }

  public String getUser_id() {
    return user_id;
  }

  public String getTt_id() {
    return tt_id;
  }

     /* Table Name String */

   public class s {
       public static final String assi_id = "assi_id";
       public static final String assi_desc = "assi_desc";
       public static final String sem = "sem";
       public static final String assi_file = "assi_file";
       public static final String status = "status";
       public static final String user_id = "user_id";
       public static final String tt_id = "tt_id";
   }

}
