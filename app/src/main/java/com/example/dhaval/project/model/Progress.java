package com.example.dhaval.project.model;

public class Progress {


     /* Initialisation */

  private String id = null;
  private String progress = "";
  private String subject = "";
  private String user_id = "";

     /* Setter */

  public void setId(String id) {
     this.id = id;
  }

  public void setProgress(String progress) {
     this.progress = progress;
  }

  public void setSubject(String subject) {
     this.subject = subject;
  }

  public void setUser_id(String user_id) {
     this.user_id = user_id;
  }

     /* Get table name */
  public static String getTableName() {
    return "progress";
  }

     /* Getter */

  public String getId() {
    return id;
  }

  public String getProgress() {
    return progress;
  }

  public String getSubject() {
    return subject;
  }

  public String getUser_id() {
    return user_id;
  }

     /* Table Name String */

   public class s {
       public static final String id = "id";
       public static final String progress = "progress";
       public static final String subject = "subject";
       public static final String user_id = "user_id";
   }

}
