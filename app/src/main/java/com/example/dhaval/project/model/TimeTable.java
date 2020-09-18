package com.example.dhaval.project.model;

public class TimeTable {


     /* Initialisation */

  private String tt_id = null;
  private String time = "";
  private String day = "";
  private String subject = "";
  private String faculty = "";
  private String sem = "";

     /* Setter */

  public void setTt_id(String tt_id) {
     this.tt_id = tt_id;
  }

  public void setTime(String time) {
     this.time = time;
  }

  public void setDay(String day) {
     this.day = day;
  }

  public void setSubject(String subject) {
     this.subject = subject;
  }

  public void setFaculty(String faculty) {
     this.faculty = faculty;
  }

  public void setSem(String sem) {
     this.sem = sem;
  }

     /* Get table name */
  public static String getTableName() {
    return "time_table";
  }

     /* Getter */

  public String getTt_id() {
    return tt_id;
  }

  public String getTime() {
    return time;
  }

  public String getDay() {
    return day;
  }

  public String getSubject() {
    return subject;
  }

  public String getFaculty() {
    return faculty;
  }

  public String getSem() {
    return sem;
  }

     /* Table Name String */

   public class s {
       public static final String tt_id = "tt_id";
       public static final String time = "time";
       public static final String day = "day";
       public static final String subject = "subject";
       public static final String faculty = "faculty";
       public static final String sem = "sem";
   }

}
