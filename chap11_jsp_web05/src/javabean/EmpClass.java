package javabean;

import java.util.ArrayList;

public class EmpClass {
	private int empno;
	private String ename;
	private String job;
	private	int mgr;
	private String hireDate;
	private int sal;
	private int comm;
	private int deptno;
	
	public EmpClass() {}
	
	public EmpClass(int empno, String ename, String job, int mgr, String hireDate, int sal, int comm,
			int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	
	

	public EmpClass(int empno, String ename, String job, String hireDate, int sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.hireDate = hireDate;
		this.sal = sal;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	
}


