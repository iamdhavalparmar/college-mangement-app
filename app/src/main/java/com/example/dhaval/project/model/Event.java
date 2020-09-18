package com.example.dhaval.project.model;

public class Event {


     /* Initialisation */

  private String event_id = null;
  private String description = "";
  private String image = "";
  private String date = "";
  private String time = "";
  private String notice_id = "";

     /* Setter */

  public void setEvent_id(String event_id) {
     this.event_id = event_id;
  }

  public void setDescription(String description) {
     this.description = description;
  }

  public void setImage(String image) {
     this.image = image;
  }

  public void setDate(String date) {
     this.date = date;
  }

  public void setTime(String time) {
     this.time = time;
  }

  public void setNotice_id(String notice_id) {
     this.notice_id = notice_id;
  }

     /* Get table name */
  public static String getTableName() {
    return "event";
  }

     /* Getter */

  public String getEvent_id() {
    return event_id;
  }

  public String getDescription() {
    return description;
  }

  public String getImage() {
    return image;
  }

  public String getDate() {
    return date;
  }

  public String getTime() {
    return time;
  }

  public String getNotice_id() {
    return notice_id;
  }

     /* Table Name String */

   public class s {
       public static final String event_id = "event_id";
       public static final String description = "description";
       public static final String image = "image";
       public static final String date = "date";
       public static final String time = "time";
       public static final String notice_id = "notice_id";
   }

}
