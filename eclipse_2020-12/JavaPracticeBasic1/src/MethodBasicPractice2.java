public class MethodBasicPractice2 {
    public static void main(String[] args) {

        int a = 18;
        int b = 6;

        // calcメソッドの呼び出し
        System.out.println("足し算：" + calc(a, b, 0));
        System.out.println("引き算：" + calc(a, b, 1));
        System.out.println("掛け算：" + calc(a, b, 2));
        System.out.println("割り算：" + calc(a, b, 3));

    }


    // ここにcalcメソッドを定義してください
    public static int calc(int value1, int value2, int type) {
    	// 戻り値格納用変数の宣言と初期化
    	int result = 0;

    	// 演算タイプによる分岐
    	switch(type) {
    	    // 足し算の場合
    		case 0:
    			result = value1 + value2;
    			break;

    		// 引き算の場合
    		case 1:
    			result = value1 = value2;
    			break;

    		// 掛け算の場合
    		case 2:
    			result = value1 * value2;
    			break;

    		// 割り算の場合
    		case 3:
    			result = value1 / value2;
    			break;

    		// 不正なタイプの場合（特に何もしない）
    		default:

    	}

    	return result;
    }

}
