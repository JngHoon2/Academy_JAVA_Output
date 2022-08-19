package classEx04;

import classEx04.vo.Takes;

public class TakesMain {

	public static void main(String[] args) {
		
		Takes[] takes = new Takes[12];
		takes[0] = new Takes("1292001", "C101-01", "B+");
		takes[1] = new Takes("1292001", "C103-01", "A+");
		takes[2] = new Takes("1292001", "C301-01", "A");
		takes[3] = new Takes("1292002", "C102-01", "A");
		takes[4] = new Takes("1292002", "C103-01", "B+");
		takes[5] = new Takes("1292002", "C502-01", "C+");
		takes[6] = new Takes("1292003", "C103-02", "B");
		takes[7] = new Takes("1292003", "C501-02", "A+");
		takes[8] = new Takes("1292301", "C102-01", "C+");
		takes[9] = new Takes("1292303", "C102-01", "C");
		takes[10] = new Takes("1292303", "C103-02", "B+");
		takes[11] = new Takes("1292303", "C501-01", "A+");
		
		showInfo(takes);
		System.out.println();
		showAP(takes);
	}
	
	public static void showInfo(Takes[] takes) {
		System.out.println("1. 전 학생 과목별 성적리스트");
		for(Takes t : takes) {
			System.out.println(t.getId() + "\t" + t.getSubject() + "\t" + t.getScore());
		}
	}

	public static void showAP(Takes[] takes) {
		System.out.println("2. 성적이 A+인 학생");
		for(Takes t : takes) {
			if(t.getScore().equals("A+"))
				System.out.println(t.getId() + "\t" + t.getSubject() + "\t" + t.getScore());
		}
	}
}
