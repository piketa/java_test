public class PrimitiveCastPractice {
    public static void main(String[] args) {

        // short型の変数 s1 を宣言し、65 を代入してください。
    	short s1 = 65;

        // s1 の値を出力してください。
    	System.out.println(s1);

        // byte型の変数 b を宣言し、変数 s1 の値を代入してください。
    	byte b = (byte)s1;

        // b の値を出力してください。
    	System.out.println(b);

        // char型の変数 c を宣言し、変数 b の値を代入してください。
    	char c = (char)b;

        // c の値を出力してください。
    	System.out.println(c);

        // short型の変数 s2 を宣言し、変数 s1 と b を足した値を代入してください。
    	short s2 = (short)(s1 + b);

        // s2 の値を出力してください。
    	System.out.println(s2);

    }
}
