package com.example.dhaval.project.model;

public class NoticeBoard {


     /* Initialisation */

  private String notice_id = null;
  private String event_id = "";
  private String image = "";

     /* Setter */

  public void setNotice_id(String notice_id) {
     this.notice_id = notice_id;
  }

  public void setEvent_id(String event_id) {
     this.event_id = event_id;
  }

  public void setImage(String image) {
     this.image = image;
  }

     /* Get table name */
  public static String getTableName() {
    return "notice_board";
  }

     /* Getter */

  public String getNotice_id() {
    return notice_id;
  }

  public String getEvent_id() {
    return event_id;
  }

  public String getImage() {
    return image;
  }

     /* Table Name String */

   public class s {
       public static final String notice_id = "notice_id";
       public static final String event_id = "event_id";
       public static final String image = "image";
   }

}
