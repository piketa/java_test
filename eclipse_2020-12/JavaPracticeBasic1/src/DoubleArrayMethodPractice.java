public class DoubleArrayMethodPractice {
    public static void main(String[] args) {

        // int二次元配列変数の宣言と初期化
        int[][] arr = {{1, 5, 8}, {2, 4, 7}, {1, 9, 3, 5}, {4, 2},
                            {6, 1, 9, 4}, {7, 3, 8, 1}, {8, 4, 3, 9, 7}};

        // 検索する数値変数の宣言と初期化
        int target = 1;

        // countメソッドの呼び出し
        System.out.println(target + "の個数：" + count(arr, target));

        // 検索する数値の変更
        target = 7;

        // countメソッドの呼び出し
        System.out.println(target + "の個数：" + count(arr, target));

    }

    // ここにcountメソッドを定義してください
    // countメソッドの定義
    public static int count(int[][] arr, int target) {

    	// カウント変数の宣言と初期化
    	int count = 0;

    	// 配列の走査（1次元目）
    	for(int i = 0; i < arr.length; i++) {

    		// 配列の走査（2次元目）
    		for(int j = 0; j < arr[i].length; j++) {

    			// 検索する数値が見つかった場合
    			if(arr[i][j] == target) {

    				// カウント変数のインクリメント
    				count++;
    			}
    		}
    	}

    	return count;
    }

}
