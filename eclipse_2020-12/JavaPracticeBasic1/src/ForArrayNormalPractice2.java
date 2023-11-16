public class ForArrayNormalPractice2 {
    public static void main(String[] args) {

        // 100人分のテストの点数を格納した配列変数points
        int[] points = {
                          69, 40, 88, 68, 13, 62, 45, 43, 28, 69,
                          54, 77, 81, 34, 41, 78, 59, 21, 45, 64,
                          55, 18, 63, 80, 64, 26, 52, 44, 61, 50,
                          44, 82, 56, 74, 67, 98, 58, 84, 77, 70,
                          60, 77, 64, 89, 59, 74, 21, 66, 85, 68,
                          90, 48, 64, 80, 63, 47, 70, 79, 51, 66,
                          23, 84, 57, 57, 76, 60, 100, 66, 79, 61,
                          47, 66, 76, 45, 90, 69, 72, 51, 86, 64,
                          57, 51, 42, 60, 71, 69, 7, 62, 77, 61,
                          43, 50, 68, 30, 78, 58, 40, 62, 70, 22
                        };

        // 階級を集計するための配列変数
        int[] level = new int[10];

        // 合計を集計するための変数
        int sum = 0;

        // テスト結果数分のループ
        for(int i = 0; i < points.length; i++) {

        	// 点数を加算していく
        	sum += points[i];

        	// 階級ごとに数え上げる
        	// 100点のみ特別に扱う
        	if(points[i] == 100) {
        		level[9]++;
        	} else {
        		level[points[i] / 10]++;
        	}
        }

        // 平均点の出力
        System.out.println("平均点：" + ((double) sum / points.length));

        System.out.println("ヒストグラム");

        // 階級毎のループ
        for(int i = 0; i < level.length; i++) {

        	// 0点台の表示を調整
        	if(i == 0) {
        		System.out.print(" 0点台");
        	} else {
        		System.out.print((i * 10) + "点台");
        	}

        	// 階級の人数分アスタリスクを出力
        	for(int j = 0; j < level[i]; j++) {
        		System.out.print("*");
        	}

        	System.out.println();
        }
    }
}
