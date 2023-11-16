public class OverrideBasicPractice {
    public static void main(String[] args) {

        // 普通の時計オブジェクトの生成
        Clock c1 = new Clock(10, 15, 30);

        // 普通の時計の情報の表示
        c1.showData();

        System.out.println();

        // 目覚まし時計オブジェクトの生成
        AlarmClock c2 = new AlarmClock(15, 45, 20, 6, 30);

        // 目覚まし時計の情報の表示
        c2.showData();

    }
}

// 時計クラス
class Clock {

    // 時分秒
    private int hour;
    private int minute;
    private int second;

    // コンストラクタ
    public Clock(int hour, int minute, int second) {

        this.hour = hour;
        this.minute = minute;
        this.second = second;

    }

    // 情報表示メソッド
    public void showData() {
        System.out.println("ただいまの時刻：" + hour + "時" + minute + "分" + second + "秒");
    }

}

// 目覚まし時計クラス
class AlarmClock extends Clock {

	// アラーム時刻（時・分）
	private int alarmHour;
	private int alarmMinute;

	// コンストラクタ
	public AlarmClock(int hour,
			int minute,
			int second,
			int alarmHour,
			int alarmMinute) {

		super(hour, minute, second);
		this.alarmHour = alarmHour;
		this.alarmMinute = alarmMinute;
	}

	// 情報表示メソッド（オーバーライド）
	@Override
	public void showData() {
		super.showData();
		System.out.println("アラーム設定時刻：" + alarmHour + "時" + alarmMinute + "分");
	}
}