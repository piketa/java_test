public class ThreadSafePractice {
    public static void main(String[] args) {

        // 募金箱オブジェクトの取得
        CollectionBox cb = CollectionBox.getInstance();

        // 偽物の募金箱を作れないようにする（コンパイルエラー）
        // CollectionBox imitation = new CollectionBox();

        // 5人の大富豪オブジェクトを生成
        MultiMillionaire mm1 = new MultiMillionaire(cb);
        MultiMillionaire mm2 = new MultiMillionaire(cb);
        MultiMillionaire mm3 = new MultiMillionaire(cb);
        MultiMillionaire mm4 = new MultiMillionaire(cb);
        MultiMillionaire mm5 = new MultiMillionaire(cb);

        // 募金の開始
        mm1.start();
        mm2.start();
        mm3.start();
        mm4.start();
        mm5.start();

        // 全員の募金が終わるまで待つ
        try {
            mm1.join();
            mm2.join();
            mm3.join();
            mm4.join();
            mm5.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        // 募金総額の発表
        System.out.println("募金総額は" + cb.getTotalAmount() + "円です。");

    }
}

// 大富豪クラス
class MultiMillionaire extends Thread {

	// 募金箱インスタンスフィールド
	private CollectionBox cb;

	// コンストラクタ
	public MultiMillionaire(final CollectionBox cb) {
		this.cb = cb;
	}

	@Override
	public void run() {

		// 1円を100万回寄付する
		for(int i = 0; i < 1000000; i++) {
			cb.contribute(1);
		}
	}
}

// 募金箱クラス
class CollectionBox {

	// 募金箱クラスフィールド
	private static CollectionBox cb;

	// 募金総額
	private int totalAmount;

	// privateコンストラクタ
	// （外部からのインスタンス化を禁止するため）
	private CollectionBox() {}

	// 募金箱インスタンスの取得
	public static CollectionBox getInstance() {

		// インスタンスがまだなければ生成
		if(cb == null) {
			cb = new CollectionBox();
		}

		return cb;
	}

	// 寄付メソッド
	public synchronized void contribute(int money) {
		totalAmount += money;
	}

	// 募金総額の取得メソッド
	public int getTotalAmount() {
		return totalAmount;
	}
}
