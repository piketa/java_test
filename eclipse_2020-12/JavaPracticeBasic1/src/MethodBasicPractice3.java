public class MethodBasicPractice3 {
    public static void main(String[] args) {

        int x = 88;
        int y = 79;
        int z = 96;

        // minメソッドの呼び出し
        System.out.println("整数" + x + "、" + y + "、" + z + "の中で最小の値は");
        System.out.println(min(x, y, z) + "です");

    }


    // ここにminメソッドを定義してください
    public static int min(int x, int y, int z) {
    	// 最小値変数の宣言と初期化（ｘを最小値と仮定）
    	int minValue = x;

    	// yの方が小さい場合、最小値変数の値を更新
    	if(minValue > y) {
    		minValue = y;
    	}

    	// zの方が小さい場合、最小値変数の値を更新
    	if(minValue > z) {
    		minValue = z;
    	}

    	return minValue;
    }

    // minメソッドの定義　その2
    public static int min2(int x, int y, int z) {
    	// xの値がyやzの値より小さい場合
    	if(x < y && x < z) {
    		return x;
    	}

    	// yの値がzの値より小さい場合
    	else if(y < z) {
    		return y;
    	}

    	// それ以外（zの値が一番小さい）
    	else {
    		return z;
    	}
    }

}
