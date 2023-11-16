public class AbstractNormalPractice {
    public static void main(String[] args) {

        // センターフォワードオブジェクトの生成
        SoccerPlayer fwd = new CenterForward("田村", 11);

        // 自己紹介
        System.out.println(fwd);

        // ボールを処理
        fwd.kickBall();
        fwd.catchBall();

        System.out.println();

        // ゴールキーパーオブジェクトの生成
        SoccerPlayer keeper = new GoalKeeper("川島", 12);

        // 自己紹介
        System.out.println(keeper);

        // ボールを処理
        keeper.kickBall();
        keeper.catchBall();

    }
}

// サッカー選手抽象クラス
abstract class SoccerPlayer {

	// 選手名
	private String name;

	// 背番号
	private int uniformNumber;

	// コンストラクタ
	public SoccerPlayer(String name, int uniformNumber) {
		this.name = name;
		this.uniformNumber = uniformNumber;
	}

	// 名前取得メソッド
	public String getName() {
		return name;
	}

	// ボールを蹴るメソッド
	public void kickBall() {
		System.out.println(name + "はボールを蹴りました");
	}

	// ボールを受け止めるメソッド
	public void catchBall() {
		System.out.println(name + "はボールを足で受け止めました");
	}

	// ポジション名取得中傷メソッド
	public abstract String getPositionName();

	@Override
	public String toString() {
		return getPositionName() + " " + name + " 背番号" + uniformNumber;
	}
}

// センターフォワードクラス
class CenterForward extends SoccerPlayer {
	public static final String POSITION_NAME = "センターフォワード";

	// コンストラクタ
	public CenterForward(String name, int uniformNumber) {
		super(name, uniformNumber);
	}

	// ポジション名取得メソッド（実装）
	public String getPositionName() {
		return POSITION_NAME;
	}
}

// ここにゴールキーパークラスを作成してください
class GoalKeeper extends SoccerPlayer {
	public static final String POSITION_NAME = "ゴールキーパー";

	// コンストラクタ
	public GoalKeeper(String name, int uniformNumber) {
		super(name, uniformNumber);
	}

	// ポジション名取得メソッド（実装）
	public String getPositionName() {
		return POSITION_NAME;
	}

	// ボールを受け止めるメソッド（オーバーライド）
	@Override
	public void catchBall() {
		System.out.println(getName() + "はボールを手で受け止めました");
	}
}
