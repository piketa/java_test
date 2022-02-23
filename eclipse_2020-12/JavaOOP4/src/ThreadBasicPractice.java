import java.util.Random;

public class ThreadBasicPractice {
    public static void main(String[] args) {

        // 平均的な性能のnormal号
        RacingCar normal = new RacingCar("Normal号", 10, 10);

        // スピードはあるがエンストが多いgambler号
        RacingCar gambler = new RacingCar("Gambler号", 20, 3);

        // 安全面を重視したcareful号
        RacingCar careful = new RacingCar("Careful号", 5, 1000);

        // 各車一斉にスタート！！
        normal.start();
        gambler.start();
        careful.start();

        // 前車がゴールするのを待つ
        try {
            normal.join();
            gambler.join();
            careful.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("レースが終了しました");

    }
}

// RacingCarクラス
class RacingCar extends Thread {

	// ゴール地点までの距離
	public static final int GOAL = 100;

	// 車の名前
	private String name;

	// 最高走行距離
	private int maxDistance;

	// エンストする場合
	private int engineStop;

	// コンストラクタ
	public RacingCar(final String name, final int maxDistance, final int engineStop) {
		this.name = name;
		this.maxDistance = maxDistance;
		this.engineStop = engineStop;
	}

	@Override
	public void run() {

		// 総走行距離
		int totalMileage = 0;

		// 一回の走行距離
		int mileage = 0;

		Random r = new Random();

		while(true) {

			try {
				// エンストするかどうか
				if(r.nextInt(engineStop) == 0) {
					System.out.println(name + "がエンストしました！");
					Thread.sleep(3000);
				} else {
					// 走行距離を取得
					mileage = r.nextInt(maxDistance) + 1;

					System.out.println(name + "が" + mileage + "km走行しました！");

					// 総走行距離に加算
					totalMileage += mileage;

					// ゴールしていたらループを抜ける
					if(totalMileage >= GOAL) {
						break;
					}

					Thread.sleep(1000);
				}
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(name + "がゴールしました！！！！！");
	}
}
