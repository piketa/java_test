public class InheritanceBasicPractice {
    public static void main(String[] args) {

        // 投手オブジェクトの生成
        Pitcher p = new Pitcher("山田", 99, 0.09, 2.13);

        // 投手の紹介
        p.introduce();

    }
}

// 野球選手クラス
class BaseballPlayer {

    // 選手名
    protected String name;

    // 背番号
    protected int uniformNumber;

    // 打率
    protected double battingAverage;

}

// 投手クラス
class Pitcher extends BaseballPlayer {

	// 防御率
	private double era;

	// コンストラクタ
	public Pitcher(String name,
			int uniformNumber,
			double battingAverage,
			double era) {

		this.name = name;
		this.uniformNumber = uniformNumber;
		this.battingAverage = battingAverage;
		this.era = era;
	}

	// 紹介メソッド
	public void introduce() {
		System.out.println("選手名：" + name);
		System.out.println("背番号：" + uniformNumber);
		System.out.println("打率　：" + battingAverage);
		System.out.println("防御率：" + era);
	}
}
