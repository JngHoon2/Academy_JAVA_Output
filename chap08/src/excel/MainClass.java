package excel;

import excel.vo.Customer;

public class MainClass {

	public static void main(String[] args) {
		try {
			MethodClass mc = new MethodClass();

			String str = "";
			str += "===========================================================\n";
			str += "고객번호	나이 		직업	결혼유무	자가여부	대출사용	연락방법	가입기간일\n";
			str += "===========================================================\n";
			System.out.println(str);
			mc.loadExcel();

			String html = MethodClass.makeTags(mc.customers);
			PrintClass.writeHtml(html);

			MethodClass.src(mc.customers);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
