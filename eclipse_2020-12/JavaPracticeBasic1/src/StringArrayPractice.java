import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringArrayPractice {
    public static void main(String[] args) throws IOException {

        // アパートに住む住人2次元配列変数
        String[][] apartment = {
                    {"後藤", "矢口", "石川", "吉澤", "藤本"},
                    {"亀井", "小川", "紺野"},
                    {"石川", "安部", "安田", "後藤"},
                    {"石黒", "福田", "後藤"}
                };

        System.out.println("検索する名前を入力してください");

        // 検索するname変数の宣言とキーボード入力値による初期化
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        // 見つけた人数変数の宣言と初期化
        int count = 0;

        // 階のループ
        for(int i = 0; i < apartment.length; i++) {

        	// 号室のループ
        	for(int j = 0; j < apartment[i].length; j++) {

        		// 見つかった場合
        		if(apartment[i][j].equals(name)) {

        			// 情報の出力
        			System.out.println(++count + "人目の" + name + "さんは、" +
        					(i + 1) + "階の" +
        					(j + 1) + "号室に住んでいます");
        		}
        	}
        }

        // 最後まで見つからなかった場合
        if(count == 0) {
        	System.out.println(name + "さんはこのアパートには住んでいません");
        }
    }
}
