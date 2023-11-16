public class InheritanceConstructorPractice {
    public static void main(String[] args) {

        // Magazineクラスのオブジェクトを生成
        Magazine magazine = new Magazine("東京Runner", 650, "上野彩");

        // 雑誌の内容紹介メソッドの呼び出し
        magazine.show();

    }
}

// Bookクラス
class Book {

    // タイトル
    private String title;

    // 価格
    private int price;

    // コンストラクタ
    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    // タイトル取得メソッド
    public String getTitle() {
        return title;
    }

    // 価格取得メソッド
    public int getPrice() {
        return price;
    }

}

// Magazineクラス
class Magazine extends Book {

	// 表紙タレント名
	private String coverPersonName;

	// コンストラクタ
	public Magazine(String title, int price, String coverPersonName) {

		super(title, price);

		this.coverPersonName = coverPersonName;
	}

	// 雑誌の内容紹介メソッド
	public void show() {
		System.out.println(getTitle() + "絶賛発売中！！");
		System.out.println("定価" + getPrice() + "円");
		System.out.println("今回の表紙：" + coverPersonName + "さん");
	}
}
