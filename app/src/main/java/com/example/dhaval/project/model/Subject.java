package com.example.dhaval.project.model;

public class Subject {


     /* Initialisation */

  private String subject_id = null;
  private String status = "";
  private String user_id = "";

     /* Setter */

  public void setSubject_id(String subject_id) {
     this.subject_id = subject_id;
  }

  public void setStatus(String status) {
     this.status = status;
  }

  public void setUser_id(String user_id) {
     this.user_id = user_id;
  }

     /* Get table name */
  public static String getTableName() {
    return "subject";
  }

     /* Getter */

  public String getSubject_id() {
    return subject_id;
  }

  public String getStatus() {
    return status;
  }

  public String getUser_id() {
    return user_id;
  }

     /* Table Name String */

   public class s {
       public static final String subject_id = "subject_id";
       public static final String status = "status";
       public static final String user_id = "user_id";
   }

}
