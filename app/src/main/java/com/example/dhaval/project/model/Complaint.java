package com.example.dhaval.project.model;

public class Complaint {


     /* Initialisation */

  private String complaint_id = null;
  private String subject = "";
  private String description = "";
  private String user_id = "";
  private String status = "";

     /* Setter */

  public void setComplaint_id(String complaint_id) {
     this.complaint_id = complaint_id;
  }

  public void setSubject(String subject) {
     this.subject = subject;
  }

  public void setDescription(String description) {
     this.description = description;
  }

  public void setUser_id(String user_id) {
     this.user_id = user_id;
  }

  public void setStatus(String status) {
     this.status = status;
  }

     /* Get table name */
  public static String getTableName() {
    return "complaint";
  }

     /* Getter */

  public String getComplaint_id() {
    return complaint_id;
  }

  public String getSubject() {
    return subject;
  }

  public String getDescription() {
    return description;
  }

  public String getUser_id() {
    return user_id;
  }

  public String getStatus() {
    return status;
  }

     /* Table Name String */

   public class s {
       public static final String complaint_id = "complaint_id";
       public static final String subject = "subject";
       public static final String description = "description";
       public static final String user_id = "user_id";
       public static final String status = "status";
   }

}
