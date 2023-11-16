import java.util.Random;

public class ExceptionInheritancePractice {
    public static void main(String[] args) {

        // 部下クラスのインスタンスを生成
        Subordinate sub = new Subordinate("有吉");

        // 上司クラスのインスタンスを生成
        Boss boss = new Boss("上島", sub);

        // 上司の働くメソッドを実行
        boss.work("得意先との取引");

    }
}

// トラブル例外クラス
class TroubleException extends Exception {}

// 社員抽象クラス
abstract class Employee {

    // 社員名
    protected String name;

    // 働く抽象メソッド
    public abstract void work(String workName) throws TroubleException;

}

// 上司クラス
class Boss extends Employee {

	// 直属の部下フィールド
	private Subordinate sub;

	// コンストラクタ
	public Boss(String name, Subordinate sub) {
		this.name = name;
		this.sub = sub;
	}

	// 働くメソッド
	public void work(String workName) {
		System.out.println("さて、今回の" + workName +
				"は部下の" + sub.getName() + "に任せよう！");
		System.out.println();

		try {
			// 部下に仕事を任せる
			sub.work(workName);

			// 無事に仕事が終わった場合
			System.out.println(sub.getName() + "君、よくやった！");
			System.out.println("さすが私の右腕だ！");
		}
		// 業務上のトラブルが発生した場合
		catch(TroubleException e) {
			System.out.println("申し訳ございません・・・");
			System.out.println(sub.getName() + "が大変失礼致しました・・・");
			System.out.println("上司のわたくし" + name + "の監督不行き届きでございます・・・");
		}
	}
}

// 部下クラス
class Subordinate extends Employee {

	// コンストラクタ
	public Subordinate(String name) {
		this.name = name;
	}

	// 働くメソッド
	public void work(String workName) throws TroubleException {
		System.out.println("今回の" + workName + "はわたくし" +
				name + "が担当致します");
		System.out.println(workName + "中・・・");

		Random r = new Random();

		// キレた場合
		if(r.nextBoolean()) {

			// トラブル発生
			System.out.println("ふざけるな、ばか野郎！");
			System.out.println();

			// トラブル例外オブジェクトのスロー
			throw new TroubleException();
		}
		// キレなかった場合
		else {
			System.out.println("今回の" + workName + "はわたくし" +
					name + "が無事任務を果たしました");
			System.out.println();
		}
	}

	// 名前取得メソッド
	public String getName() {
		return name;
	}
}

