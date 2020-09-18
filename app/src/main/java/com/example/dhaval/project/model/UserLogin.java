package com.example.dhaval.project.model;

public class UserLogin {


     /* Initialisation */

  private String user_id = null;
  private String username = "";
  private String password = "";
  private String email = "";
  private String contact = "";
  private String address = "";
  private String user_type = "";
  private String city = "";
  private String blood_group = "";
  private String dob = "";
  private String progress = "";


    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }


    /* Setter */

  public void setUser_id(String user_id) {
     this.user_id = user_id;
  }

  public void setUsername(String username) {
     this.username = username;
  }

  public void setPassword(String password) {
     this.password = password;
  }

  public void setEmail(String email) {
     this.email = email;
  }

  public void setContact(String contact) {
     this.contact = contact;
  }

  public void setAddress(String address) {
     this.address = address;
  }

  public void setUser_type(String user_type) {
     this.user_type = user_type;
  }

  public void setCity(String city) {
     this.city = city;
  }

  public void setBlood_group(String blood_group) {
     this.blood_group = blood_group;
  }

  public void setDob(String dob) {
     this.dob = dob;
  }

     /* Get table name */
  public static String getTableName() {
    return "user_login";
  }

     /* Getter */

  public String getUser_id() {
    return user_id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  public String getContact() {
    return contact;
  }

  public String getAddress() {
    return address;
  }

  public String getUser_type() {
    return user_type;
  }

  public String getCity() {
    return city;
  }

  public String getBlood_group() {
    return blood_group;
  }

  public String getDob() {
    return dob;
  }

     /* Table Name String */

   public class s {
       public static final String user_id = "user_id";
       public static final String username = "username";
       public static final String password = "password";
       public static final String email = "email";
       public static final String contact = "contact";
       public static final String address = "address";
       public static final String user_type = "user_type";
       public static final String city = "city";
       public static final String blood_group = "blood_group";
       public static final String dob = "dob";
   }

}
