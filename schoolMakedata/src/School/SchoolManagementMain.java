package School;
import java.util.ArrayList;

import School.vo.*;

public class SchoolManagementMain {

	public static void main(String[] args) {
		//데이터 생성(객체들이 생성되어 메모리에 올라감)
				//MakeData data = new MakeData();
				
				/**
				 * [문제.1] 전체 학생 명단을 출력하시오.
				 */
				//데이터 생성
				MakeData md = new MakeData();
				ArrayList<Student> students = md.studentList;
				/**
				 * [문제.1] 전체 학생 리스트를 출력하시오.
				 */
				// 교수 데이터 생성
				System.out.println("======================== 1.전체 학생 정보 리스트 ======================");
				for(Student s : students) {
					System.out.println(s.getId() + " " + s.getName() +  " " + s.getJumin() +  " " + s.getYear() +  " " + s.getAddress() +  " " + s.getDepartment());
				}
				System.out.println();	//한줄을 띄는 용도
				
				/**
				 * [문제.2] 교수 리스트를 출력하시오.
				 */
				ArrayList<Professor> professors = md.professorList;
				System.out.println("======================= 2.교수 리스트 ======================");
				for(Professor p : professors) {
					System.out.printf("%s  %s  %s  \n", p.getId(), p.getJumin(), p.getName());
					}
				System.out.println();	//한줄을 띄는 용도

				/**
				 * [문제.3] 학과 리스트를 출력하시오.
				 */
				
				ArrayList<Department> departments = md.departmentList;
				System.out.println("=================== 3.학과 리스트 =====================");
				for(Department d : departments) {
					System.out.println(d.getId() + "\t" + d.getName() + " \t" + d.getOffice());
				}
				System.out.println();	//한줄을 띄는 용도

				/**
				 * [문제.4] 성적 데이터를 출력하시오.
				 */
				ArrayList<Takes> takes = md.takesList;
				System.out.println("=================== 4.성적 데이터 =====================");
				for(Takes t : takes) {
					System.out.println(t.getId() + "\t" + t.getSubject() + " \t" + t.getScore());
				}
				
				System.out.println();
				System.out.println("=================== 5.학생정보와 소속 학과 명 =====================");
				for(Student s : students) {
					for(Department d : departments) {
						if(s.getDepartment() == d.getId()) {
							System.out.println(s.getId() + " " + s.getName() +  " " + s.getJumin() +  " " + s.getYear() +  " " + s.getAddress() 
							+  " " + s.getDepartment()+  " " + d.getName());
						}
					}
				}
				System.out.println();
				System.out.println("=================== 6.특정 학생 정보 출력 =====================");
				for(Takes t : takes) {
					for(Student s:students) {
						if(t.getId() == s.getId()) {
							System.out.println(s.getId() + " " + s.getName() +  " " + s.getJumin() +  " " + s.getYear() +  " " + s.getAddress() 
							+  " " + s.getDepartment()+  " " + t.getSubject() + " " + t.getScore());
						}
					}
				}
				
	}

}
