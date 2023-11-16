public class OriginalExceptionPractice {
    public static void main(String[] args) {

        // 自動車オブジェクトの生成
        Car mycar = new Car(123, "ロミオ", 0.8);

        // ガソリンがなくなるまで走行する
        try {
            while(true) {
                // 走行する
                mycar.run();
            }
        } catch(GasolineException e) {
            System.out.println(e.getMessage());
        }

    }
}

// 車クラス
class Car {
	private int number;		// ナンバー
	private String type;	// 車種
	private double gas;		// ガソリン量

	// コンストラクタ
	public Car(int number, String type, double gas) {
		this.number = number;
		this.type = type;
		this.gas = gas;
	}

	// 走行させる
	public void run() throws GasolineException {

		// ガソリン量チェック
		if(gas < 0.1) {

			// ガス欠例外のスロー
			throw new GasolineException(
					"ナンバー" + number + "の" + type +
					"はガソリン不足のため走行できません。");
		} else {

			// 走行メッセージの表示
			System.out.println("ナンバー" + number + "の" + type + "は走行しています。");

			// ガソリンを0.1リットル減らす
			gas -= 0.1;
		}
	}
}

// ガス欠例外クラス
class GasolineException extends Exception {
	public GasolineException(String message) {
		super(message);
	}
}