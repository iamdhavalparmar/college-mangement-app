package com.example.dhaval.project.model;

public class Feedback {


     /* Initialisation */

  private String feedback_id = null;
  private String user_id = "";
  private String description = "";
  private String user_type = "";

     /* Setter */

  public void setFeedback_id(String feedback_id) {
     this.feedback_id = feedback_id;
  }

  public void setUser_id(String user_id) {
     this.user_id = user_id;
  }

  public void setDescription(String description) {
     this.description = description;
  }

  public void setUser_type(String user_type) {
     this.user_type = user_type;
  }

     /* Get table name */
  public static String getTableName() {
    return "feedback";
  }

     /* Getter */

  public String getFeedback_id() {
    return feedback_id;
  }

  public String getUser_id() {
    return user_id;
  }

  public String getDescription() {
    return description;
  }

  public String getUser_type() {
    return user_type;
  }

     /* Table Name String */

   public class s {
       public static final String feedback_id = "feedback_id";
       public static final String user_id = "user_id";
       public static final String description = "description";
       public static final String user_type = "user_type";
   }

}
