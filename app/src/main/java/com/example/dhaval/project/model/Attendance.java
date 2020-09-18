package com.example.dhaval.project.model;

public class Attendance {


     /* Initialisation */

  private String id = null;
  private String roll_no = "";
  private String date = "";
  private String lacture = "";
  private String semester = "";
  private String present = "";
  private String total = "";
  private String available = "";

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  public String getAvailable() {
    return available;
  }

  public void setAvailable(String available) {
    this.available = available;
  }

  /* Setter */

  public void setId(String id) {
    if (id == null || !id.equals("")) this.id = id;
  }

  public void setRoll_no(String roll_no) {
    if (roll_no == null || !roll_no.equals("")) this.roll_no = roll_no;
  }

  public void setDate(String date) {
    if (date == null || !date.equals("")) this.date = date;
  }

  public void setLacture(String lacture) {
    if (lacture == null || !lacture.equals("")) this.lacture = lacture;
  }

  public void setSemester(String semester) {
    if (semester == null || !semester.equals("")) this.semester = semester;
  }

  public void setPresent(String present) {
    if (present == null || !present.equals("")) this.present = present;
  }

     /* Get table name */
  public static String getTableName() {
    return "attendance";
  }

     /* Getter */

  public String getId() {
    return id;
  }

  public String getRoll_no() {
    return roll_no;
  }

  public String getDate() {
    return date;
  }

  public String getLacture() {
    return lacture;
  }

  public String getSemester() {
    return semester;
  }

  public String getPresent() {
    return present;
  }

     /* Table Name String */

   public class s {
       public static final String id = "id";
       public static final String roll_no = "roll_no";
       public static final String date = "date";
       public static final String lacture = "lacture";
       public static final String semester = "semester";
       public static final String present = "present";
   }

}
