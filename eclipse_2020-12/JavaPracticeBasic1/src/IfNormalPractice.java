public class IfNormalPractice {
    public static void main(String[] args) {

        // 年齢変数の宣言と初期化
        int age = 25;        // ←値を変更しながら実行

        System.out.println("年齢：" + age);

        // if文の開始
        if(age >= 20) {		// 20歳異常の場合
        	System.out.println("成人です");
        } else if(age < 20 && age >= 0) {	// 20歳未満0歳以上の場合
        	System.out.println("未成年です");

        	if(age < 6 || age > 14) {		// 6歳未満14歳より大きい場合
        		System.out.println("今は義務教育を受けていません");
        	} else {	// それが以外の場合
        		System.out.println("今は義務教育を受けています");
        	}
        } else {	// それ以外（負の値）の場合
        	System.out.println("エラー");
        }
    }
}
