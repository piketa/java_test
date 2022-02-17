import java.util.HashMap;

public class HashMapNormalPractice {
    public static void main(String[] args) {

        // 金庫インスタンスの作成
        StrongBox guard = new StrongBox();

        // 秘密の言葉変数の宣言
        String secret = null;

        try {
            // 1つ目の宝物を格納
            secret = "sgf01";
            guard.store(secret, new Treasure("ダイヤの指輪"));

            // 2つ目の宝物を格納
            secret = "zkq02";
            guard.store(secret, new Treasure("真珠のネックレス"));

            // 3つ目の宝物を格納
            secret = "xrt03";
            guard.store(secret, new Treasure("金のブレスレット"));

            // 4つ目の宝物を格納（秘密の言葉が重複）
            secret = "xrt03";
            guard.store(secret, new Treasure("プラチナのイヤリング"));

        } catch(DuplicateSecretException e) {
            System.out.println("秘密の言葉「" + secret + "」はすでにつかわれています");
        }

        System.out.println();

        try {
            // 1つ目の宝物を取得
            secret = "sgf01";
            Treasure treasure1 = guard.getTreasure(secret);
            System.out.println(treasure1 + "をゲットしました！");

            // 2つ目の宝物を取得
            secret = "zkq02";
            Treasure treasure2 = guard.getTreasure(secret);
            System.out.println(treasure2 + "をゲットしました！");

            // 3つ目の宝物を取得（秘密の言葉が不正）
            secret = "xrr03";
            Treasure treasure3 = guard.getTreasure(secret);
            System.out.println(treasure3 + "をゲットしました！");

        } catch(IllegalSecretException e) {
            System.out.println("秘密の言葉「" + secret + "」は不正です");
        }

    }
}

// 宝物クラス
class Treasure {

	// タイプ
	private String type;

	// コンストラクタ
	public Treasure(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}
}

// 秘密の言葉不正例外クラス
class IllegalSecretException extends Exception {}

// 秘密の言葉重複例外クラス
class DuplicateSecretException extends Exception {}

// 金庫クラス
class StrongBox {

	// 宝物保持マップ
	private HashMap<String, Treasure> treasures;

	// コンストラクタ
	public StrongBox() {
		treasures = new HashMap<String, Treasure>();
	}

	// 秘密の言葉と宝物を金庫に格納する
	public void store(String secret, Treasure treasure) throws DuplicateSecretException {

		// すでに秘密の言葉が使用済みの場合
		if(treasures.containsKey(secret)) {

			// 秘密の言葉重複例外をスローする
			throw new DuplicateSecretException();
		} else {
			System.out.println(treasure + "を金庫に格納しました！");

			// 金庫に宝物を格納する
			treasures.put(secret, treasure);
		}
	}

	// 秘密の言葉で宝物を取り出す
	public Treasure getTreasure(String secret) throws IllegalSecretException {

		// 秘密の言葉を使って宝物保持マップから宝物を取得
		Treasure treasure = treasures.get(secret);

		// 秘密の言葉が不正の場合
		if(treasure == null) {

			// 秘密の言葉不正例外をスローする
			throw new IllegalSecretException();

		} else {

			// 宝物を戻り値として返す
			return treasure;
		}
	}
}
