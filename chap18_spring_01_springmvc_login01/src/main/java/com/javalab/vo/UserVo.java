package com.javalab.vo;

import java.sql.Date;

public class UserVo {
   private String id;
   private String pwd;
   private String name;
   private String email;
   private String role;   
   private Date joinDate;
   
   public UserVo() {
   }

   public UserVo(String id, String name, String email, String role, Date joinDate) {
      super();
      this.id = id;
      this.name = name;
      this.email = email;
      this.role = role;
      this.joinDate = joinDate;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getPwd() {
      return pwd;
   }

   public void setPwd(String pwd) {
      this.pwd = pwd;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }


   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Date getJoinDate() {
      return joinDate;
   }

   public void setJoinDate(Date joinDate) {
      this.joinDate = joinDate;
   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   @Override
   public String toString() {
      return "UserVo [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", role=" + role
            + ", joinDate=" + joinDate + "]";
   }

}