public class ArrayMethodPractice2 {
    public static void main(String[] args) {

        int[] arr = {43, 2, 765, 234, 908, 115, 32,
                    476, 938, 65, 93, 47, 102, 735,
                    529, 1010, 639, 660, 182, 908};

        // maxメソッドの呼び出し

        System.out.println("配列の最大値：" + max(arr));

    }


    // ここにmaxメソッドを定義してください
    public static int max(int[] arr) {

    	// 最大値格納用変数の宣言と初期化
    	int maxValue = 0;

    	// 配列の走査
    	for(int i = 0; i < arr.length; i++) {

    		// 配列要素が最大値変数より大きい場合
    		if(arr[i] > maxValue) {

    			// 配列要素で上書きする
    			maxValue = arr[i];

    		}
    	}

    	return maxValue;
    }

}
