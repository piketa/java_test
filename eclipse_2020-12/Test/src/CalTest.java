import java.util.Calendar;

public class CalTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();

		int weeks = cal.get(Calendar.WEEK_OF_MONTH);
		int the_day = cal.get(Calendar.DAY_OF_WEEK);

		System.out.println("今日の月 : " + (cal.get(Calendar.MONTH)+1));
		System.out.println("今日の日付 : " + cal.get(Calendar.DATE));
		System.out.println("Weeks : " + weeks);
		System.out.println("The_day : " + the_day);
	}

}
