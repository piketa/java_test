import java.util.ArrayList;
public class ArrayListBasicPractice {
    public static void main(String[] args) {

        // 英数字単語格納用変数の宣言とArrayListオブジェクトの生成
        ArrayList<String> number = new ArrayList<String>();

        // 英数字単語の格納
        number.add("zero");
        number.add("one");
        number.add("two");
        number.add("three");
        number.add("four");
        number.add("five");
        number.add("six");
        number.add("seven");
        number.add("eight");
        number.add("nine");
        number.add("ten");

        // 英単語の入力
        System.out.println("0から10までの英単語を入力してください");

        String input = System.console().readLine();

        // 見つかったことを判定するフラグ変数
        boolean flag = false;

        // 入力英単語の存在チェック
        for(int i = 0; i < number.size(); i++) {

        	// 文字列の等値チェック
        	if(number.get(i).equals(input)) {
        		System.out.println(input + "は数値の" + i + "です");
        		flag = true;
        		break;
        	}
        }

        // 入力英単語が不正の場合
        if(!flag) {
        	System.out.println(input + "は英単語として存在しません");
        }
    }
}
