
public class Test {

	public static void main(String[] args) {
		int a = 10;
//		int b = a++ + a + a-- - a-- + ++a;
		int b = a++ + a + a-- - a-- + ++a;
		System.out.println(b);


		int a1 = 10;
		int b1 = a1++ + a1;
		System.out.println(b1);
	}

}
