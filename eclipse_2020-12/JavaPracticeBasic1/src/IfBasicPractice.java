public class IfBasicPractice {
	public static void main(String[] args) {

		// 整数変数の宣言と初期化
		int value = 16;        // ←値を変更しながら実行

		System.out.println("value：" + value);


		// if文の開始
		// 偶数・奇数の判定
		if(value % 2 == 0) {
			System.out.println("偶数です");
		} else {
			System.out.println("奇数です");
		}

		// 3の倍数の判定
		if(value % 3 == 0) {
			System.out.println("3の倍数です");
		}

		// 4の倍数の判定
		if(value % 4 == 0) {
			System.out.println("4の倍数です");
		}

		// 5の倍数の判定
		if(value % 5 == 0) {
			System.out.println("5の倍数です");
		}
    }
}
