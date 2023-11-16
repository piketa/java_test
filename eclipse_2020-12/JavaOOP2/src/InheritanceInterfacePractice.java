public class InheritanceInterfacePractice {
    public static void main(String[] args) {

        // ミュージシャン配列の作成
        Musician[] band = {
                    new Vocalist("桜井"),
                    new Guitarist("田原", "リードギター"),
                    new Guitarist("中川", "ベース"),
                    new ChorusDrummer("鈴木")
        };

        // ミュージックスタート！
        for(int i = 0; i < band.length; i++) {

        	// 歌うこと可能であれば歌う
        	if(band[i] instanceof Singable) {
        		((Singable)band[i]).sing();
        	}

        	// 演奏可能であれば演奏する
        	if(band[i] instanceof Playable) {
        		((Playable)band[i]).play();
        	}
        }

    }
}

// ミュージシャン抽象クラス
abstract class Musician {

    // 名前フィールド
    private String name;

    // コンストラクタ
    public Musician(String name) {
        this.name = name;
    }

    // 名前取得メソッド
    public String getName() {
        return name;
    }

}

// 歌唱可能インタフェース
interface Singable {
    void sing();
}

// 演奏可能インタフェース
interface Playable {
    void play();
}

// ボーカリストクラス
class Vocalist extends Musician implements Singable {

	// コンストラクタ
	public Vocalist(String name) {
		super(name);
	}

	// 歌うメソッドの実装
	public void sing() {
		System.out.println(getName() + "は熱唱しました！");
	}
}

// ギタリストクラス
class Guitarist extends Musician implements Playable {

	// ギタータイプ名
	private String guitarType;

	// コンストラクタ
	public Guitarist(String name, String guitarType) {
		super(name);
		this.guitarType = guitarType;
	}

	// 演奏メソッドの実装
	public void play() {
		System.out.println(getName() + "は" + guitarType + "を演奏しました！");
	}
}

// コーラス＆ドラマークラス
class ChorusDrummer extends Musician implements Singable, Playable {

	// コンストラクタ
	public ChorusDrummer(String name) {
		super(name);
	}

	// 歌うメソッドの実装
	public void sing() {
		System.out.println(getName() + "はコーラスでハモりました！");
	}

	// 演奏メソッドの実装
	public void play() {
		System.out.println(getName() + "はドラムを演奏しました！");
	}
}
