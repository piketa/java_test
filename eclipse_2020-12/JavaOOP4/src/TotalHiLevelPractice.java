import java.util.ArrayList;
public class TotalHiLevelPractice {
    public static void main(String[] args) {

        // ホテルがオープン
        Hotel hotel = new Hotel("ホテルドルフィン");

        // ホテルに3人の従業員が出勤
        hotel.enter(new Staff("坂本", "清掃"));
        hotel.enter(new Staff("長野", "調理"));
        hotel.enter(new Staff("井ノ原", "接客"));

        System.out.println();

        // 3人のお客様がチェックイン（1人が所持金不足で泊まれず）
        hotel.enter(new Customer("岡田", 500000), Hotel.RoomRank.SUITE);
        hotel.enter(new Customer("三宅", 40000), Hotel.RoomRank.NORMAL);
        hotel.enter(new Customer("森田", 4000), Hotel.RoomRank.ECONOMY);

        System.out.println();

        // ホテルを運営
        hotel.manage();

        System.out.println();

        // お客様情報の確認
        hotel.showCustomerInfo();

        System.out.println();

        // ホテル情報の確認
        hotel.showHotelInfo();

    }
}

// ホテルクラス
class Hotel {

	// ホテル名
	private String name;

	// 利益
	private long profits;

	// 従業員たち
	private ArrayList<Staff> staffs;

	// お客様たち
	private ArrayList<Customer> customers;

	// ネスト列挙型RoomRank
	public enum RoomRank {

		SUITE("スイートルーム", 100000),
		NORMAL("通常ルーム", 20000),
		ECONOMY("格安ルーム", 5000);

		// 部屋のランク名
		private String roomRankName;

		// 価格
		private int price;

		// コンストラクタ
		private RoomRank(final String roomRankName, final int price) {
			this.roomRankName = roomRankName;
			this.price = price;
		}

		// 価格取得
		public int getPrice() {
			return price;
		}

		@Override
		public String toString() {
			return roomRankName;
		}
	}

	// コンストラクタ
	public Hotel(final String name) {
		this.name = name;
		System.out.println(name + "がオープンしました");
		staffs = new ArrayList<Staff>();
		customers = new ArrayList<Customer>();
	}

	// ホテルに入るメソッド（オーバーロード）
	public void enter(final Staff staff) {
		System.out.println(staff.getName() + "が" + name + "に出勤しました");

		// 従業員格納用ArrayListに登録
		staffs.add(staff);
	}

	// ホテルに入るメソッド（オーバーロード）
	public void enter(final Customer customer, final RoomRank rank) {
		try {
			// お客様の部屋ランクに応じた支払（ホテルの利益を加算する）
			profits += customer.pay(rank.getPrice());

			System.out.println(customer.getName() + "様が" + name + "の" + rank + "にお泊まりになります");

			// 顧客格納用ArrayListに登録
			customers.add(customer);
		}
		// 所持金が不足している場合
		catch(ShortFallException e) {
			System.out.println(e.getMessage());
		}
	}

	// ホテル運営メソッド
	public void manage() {
		for(Staff staff : staffs) {
			staff.work();
		}
	}

	// お客様情報出力メソッド
	public void showCustomerInfo() {
		System.out.println("お客様情報");
		for(Customer customer : customers) {
			System.out.println(customer);
		}
	}

	// ホテル情報出力メソッド
	public void showHotelInfo() {
		System.out.println(name + "の現在の状況");
		System.out.println("現在働いている従業員数：" + customers.size() + "名");
		System.out.println("現在の利益：" + profits + "円");
	}
}

// 人抽象クラス
abstract class Person {

    // 氏名
    protected String name;

    // 名前取得メソッド
    public String getName() {
        return name;
    }

}

// 労働可能インタフェース
interface Workable {

    // 働く抽象メソッド
    void work();

}

// 従業員クラス
class Staff extends Person implements Workable {

	// 職種
	private String jobType;

	// コンストラクタ
	public Staff(final String name, final String jobType) {
		this.name = name;
		this.jobType = jobType;
	}

	// 働くメソッドの実装
	public void work() {
		System.out.println(name + "が" + jobType + "を行いました");
	}
}

// 顧客クラス
class Customer extends Person {

	// 所持金
	private int money;

	// コンストラクタ
	public Customer(final String name, final int money) {
		this.name = name;
		this.money = money;
	}

	// 支払メソッド
	public int pay(final int money) throws ShortFallException {

		// 所持金が足りない場合
		if(this.money < money) {
			throw new ShortFallException(name + "は所持金不足です");
		} else {
			// 所持金を減らしてから戻り値として支払う
			this.money -= money;
			return money;
		}
	}

	@Override
	public String toString() {
		return name + "様　所持金：" + money + "円";
	}
}

// 所持金不足例外クラス
class ShortFallException extends Exception {

    public ShortFallException(String message) {
        super(message);
    }

}
