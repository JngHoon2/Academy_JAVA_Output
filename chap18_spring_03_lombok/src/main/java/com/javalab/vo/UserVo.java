package com.javalab.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter				// 게터 생성 
@Setter				// 세터 생성 
@NoArgsConstructor	// 기본 생성자 생성
@AllArgsConstructor // 모든 클래스 변수를 파라미터로 가지는 생성자 생성
@ToString 			// toString 메소드 생성

public class UserVo {
   private String id;
   private String pwd;
   private String name;
   private String email;
   private String role;   
   private Date joinDate;
   
//   public UserVo() {
//   }
//
//   public UserVo(String id, String name, String email, String role, Date joinDate) {
//      super();
//      this.id = id;
//      this.name = name;
//      this.email = email;
//      this.role = role;
//      this.joinDate = joinDate;
//   }
//
//   public String getId() {
//      return id;
//   }
//
//   public void setId(String id) {
//      this.id = id;
//   }
//
//   public String getPwd() {
//      return pwd;
//   }
//
//   public void setPwd(String pwd) {
//      this.pwd = pwd;
//   }
//
//   public String getName() {
//      return name;
//   }
//
//   public void setName(String name) {
//      this.name = name;
//   }
//
//
//   public String getEmail() {
//      return email;
//   }
//
//   public void setEmail(String email) {
//      this.email = email;
//   }
//
//   public Date getJoinDate() {
//      return joinDate;
//   }
//
//   public void setJoinDate(Date joinDate) {
//      this.joinDate = joinDate;
//   }
//
//   public String getRole() {
//      return role;
//   }
//
//   public void setRole(String role) {
//      this.role = role;
//   }
//
//   @Override
//   public String toString() {
//      return "UserVo [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", role=" + role
//            + ", joinDate=" + joinDate + "]";
//   }

}