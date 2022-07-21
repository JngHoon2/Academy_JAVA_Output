package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.db.DatabaseClass;
import database.db.PrintClass;
import database.vo.EmpClass;
import database.vo.TempClass;

public class MainClass {

	public static void main(String[] args) {
		// 1. 데이터베이스 관련 DatabaseClass 객체 생성
		DatabaseClass dbc = new DatabaseClass();
		
		// 데이터베이스 커넥션,연결(db명, 비밀번호를 문자열을 인자로 전달하고 있음)
		dbc.connectDB("xe", "1234");
				
		// 2. 사원 목록  저장용 ArrayList 선언
		ArrayList<EmpClass> allEmpArray = new ArrayList<EmpClass>();
				
		// 2.1 전 사원의 목록을 ArrayList로 받아옴
		ResultSet rs = dbc.selectAll();
		try {
			while(rs.next()) {
				allEmpArray.add(new EmpClass(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"), rs.getString("hireDate")
						, rs.getInt("sal"), rs.getInt("comm"), rs.getInt("deptno")));
			}
		} catch (SQLException e) {
			System.out.println("ArrayList 삽입 오류 : " + e.getMessage());
		}
		
				
		System.out.println("전체사원의 수는 : " + allEmpArray.size());

		// 2.2 전사원 목록 Html tag 생성
		rs = dbc.selectAll();
		
		PrintClass pc = new PrintClass();
		String tagAllEmp = pc.makeTagsAllEmp(rs);
		
		// 2.3 Html 파일을 파일에 쓰기
		String uriAllEmpHTML = "/Users/tuan/Documents/works/chap08_databaseEx0402/AllEmp.html";
		pc.makeHTML(tagAllEmp, uriAllEmpHTML);		
				
				
		// 3. 직급별 급여 평균보다 낮은 급여를 가진 직급의 이름, 사원수, 
		//    급여합계, 급여 평균을 구하되 평균급여 별로 내림차순 정렬하시오.
				
		// 3.1 3.번 문제의 결과를 담을 데이터 전송 객체 디자인
		
				
		// 3.2 3.번 문제 담을 ArrayList<E> 선언
		ArrayList<TempClass> tArray = new ArrayList<TempClass>();		
		
		// 3.3 DatabaseClass의 메소드에 조회결과 요청
		rs = dbc.selectAVG();
		
		try {
			while(rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
				tArray.add(new TempClass(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4)));
			}
		} catch (SQLException e) {
			System.out.println("tArray 삽입 오류 : " + e.getMessage());
		}
		// 태그 생성
		rs = dbc.selectAVG();
		String tagAVG = pc.makeTagsAVG(rs);
		
		// 파일에 쓰기	
		String uriAVG = "/Users/tuan/Documents/works/chap08_databaseEx0402/AVGHigh.html";
		pc.makeHTML(tagAVG, uriAVG);		
		
		
		// 직급별 평균 급여
		double sum = 0;
		for(TempClass t : tArray) {
			sum += t.getAvg();
		}
		double avg = sum / tArray.size();
		
		
		System.out.println("직급 별 평균 급여 : " + avg);
		
	}

}
