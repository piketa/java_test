import java.util.Calendar;

public class CalTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();

		//その月の1日が何曜日かを調べる為に日付を1日にする
		cal.set(Calendar.DATE, 1);

		//カレンダーの最初の空白の数
		int before = cal.get(Calendar.DAY_OF_WEEK)-1;
		System.out.println("before : " + before);

		//カレンダーの日付の数
		int daysCount = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("daysCount : " + daysCount);

		//その月の最後の日が何曜日かを調べるために日付を最終日にする
		cal.set(Calendar.DATE, daysCount);

		//最後の日後の空白の数
		int after = 7-cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("after : " + after);

		//すべての要素数
		int total = before+daysCount+after;
		System.out.println("total : " + total);

		//その要素数を幅7個の配列に入れていった場合何行になるか
		int rows = total/7;
		System.out.println("rows : " + rows);

		//その行数で2次元配列を生成
		String[][] date = new String[rows][7];




		int weeks = cal.get(Calendar.WEEK_OF_MONTH);
		int the_day = cal.get(Calendar.DAY_OF_WEEK);

		System.out.println("今日の月 : " + (cal.get(Calendar.MONTH)+1));
		System.out.println("今日の日付 : " + cal.get(Calendar.DATE));
		System.out.println("Weeks : " + weeks);
		System.out.println("The_day : " + the_day);
	}

}
