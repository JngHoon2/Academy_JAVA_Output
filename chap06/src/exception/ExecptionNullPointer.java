package exception;

public class ExecptionNullPointer {

	public static void main(String[] args) {
		
		try {
			String[] strings = null;
			System.out.println(strings.length);
			
		}catch (Exception e) {
			System.out.println(e);
		}

		try {
			String[] arrStr = new String[2];
			arrStr[0] = "hi";
			arrStr[1] = "hello";
			System.out.println(arrStr[0]);
			System.out.println(arrStr[2]);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			String data1 = "100";
			String data2 = "a100";
			
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int value3 = value1 + value2;
			
			System.out.println(value3);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
