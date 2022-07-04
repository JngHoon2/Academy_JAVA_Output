package classEx04;

import classEx04.vo.Department;

public class DepartmentMain {

	public static void main(String[] args) {
		Department[] departments = new Department[3];
		
		departments[0] = new Department(920, "컴퓨터공학과", "201호");
		departments[1] = new Department(923, "산업공학과", "207호");
		departments[2] = new Department(925, "전자공학과", "308호");
	
		showInfo(departments);
		System.out.println();
		show923(departments);
	}
	
	public static void showInfo(Department[] departments) {
		System.out.println("================= 학과 목록 ==================");
		for(Department department : departments) {
			if(department.getName().length() > 5) {
				System.out.println(department.getId() + "\t" + department.getName() + "\t" + department.getOffice());				
			}
			else {
				System.out.println(department.getId() + "\t" + department.getName() + "\t\t" + department.getOffice());
			}
		}
	}
	
	public static void show923(Department[] departments) {
		System.out.println("======= id가 923인 학과 코드, 이름, 오피스 =======");
		for(Department department : departments) {
		if(department.getId() == 923)
			System.out.println(department.getId() + "\t" + department.getName() + "\t" + department.getOffice());
		}
	}

}
