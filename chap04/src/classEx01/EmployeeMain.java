package classEx01;

import java.awt.event.ItemEvent;

import classEx01.vo.Employee;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee employee1 = new Employee("A", 28, 400, "KR", 10, "정규");
		Employee employee2 = new Employee("B", 27, 600, "KR", 15, "정규");
		Employee employee3 = new Employee("C", 26, 280, "JP", 1, "비정규");
		Employee employee4 = new Employee("D", 25, 360, "JP", 2, "비정규");
		Employee employee5 = new Employee("E", 23, 270, "RU", 1, "정규");
		Employee employee6 = new Employee("F", 27, 390, "AM", 4, "정규");
		Employee employee7 = new Employee("G", 31, 330, "SI", 3, "정규");
		Employee employee8 = new Employee("H", 35, 280, "CA", 2, "비정규");
		Employee employee9 = new Employee("I", 38, 450, "FR", 10, "정규");
		Employee employee10 = new Employee("J", 45, 600, "JP", 15, "정규");

		Employee[] list = { employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8,
				employee9, employee10 };

		System.out.println("이름\t나이\t급여\t근무국가\t근무년수\t사원");
		for (Employee employee : list) {
			System.out.println(employee.getName() + "\t" + employee.getAge() + "\t" + employee.getSalary() + "\t"
					+ employee.getCountry() + "\t" + employee.getYear() + "\t" + employee.getType());
		}

		System.out.println("정규직 직원들의 평균 급여 : " + avgSalary(list));
		System.out.println("일본 직원들의 평균 급여 : " + japanAvgSalary(list));
	}

	public static double avgSalary(Employee[] emp) {
		double sum = 0;
		int reg_cnt = 0;
		for (Employee employee : emp) {
			if (employee.getType().equals("정규")) {
				sum += employee.getSalary();
				reg_cnt++;				
			}
		}
		return Math.round((double)sum / reg_cnt * 100) * 0.01;
	}

	public static double japanAvgSalary(Employee[] emp) {
		double sum = 0;
		int jp_cnt = 0;
		for (Employee employee : emp) {
			if (employee.getCountry().equals("JP")) {
				sum += employee.getSalary();
				jp_cnt++;
			}
		}
		return Math.round((double)sum / jp_cnt * 100) * 0.01;
	}
}
