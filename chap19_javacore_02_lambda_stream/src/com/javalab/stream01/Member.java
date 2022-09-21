package com.javalab.stream01;

public class Member {
   private String name;
   private String job;
   
   public Member(String name, String job) {
      super();
      this.name = name;
      this.job = job;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getJob() {
      return job;
   }
   public void setJob(String job) {
      this.job = job;
   }
   @Override
   public String toString() {
      return "Member [name=" + name + ", job=" + job + "]";
   }
}
   