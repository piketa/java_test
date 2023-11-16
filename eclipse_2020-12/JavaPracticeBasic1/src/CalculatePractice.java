public class CalculatePractice {
	public static void main(String[] args) {

        // 5 と 6 と 7 を足した合計に 8 を掛けた値は？
        System.out.println( (5 + 6 + 7) * 8 );		// 144

        // 7 と 8 を足した値を 5 で割った値に、
        // 6 から 4 を引いた値に 2 を掛けた値を足した値は？
        System.out.println( ((7 + 8) / 5) + ((6 - 4) * 2));		// 7

        // 1000 を 7 で割ったあまりは？
        System.out.println( 1000 % 7);		// 6

        // 6 を 5 で割った値を、さらに 2 で割った正確な値は？
        System.out.println( (6.0 / 5) / 2);		// 0.6
        System.out.println( ((double)6 / 5) / 2);		// 0.6
        System.out.println( (6D / 5) / 2);		// 0.6

        // アルファベットの大文字 'A' に 32 を足した文字は？
        System.out.println( (char)('A' + 32));		// a

	}
}
