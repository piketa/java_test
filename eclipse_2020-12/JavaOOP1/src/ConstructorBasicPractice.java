public class ConstructorBasicPractice {
    public static void main(String[] args) {

        // Squareクラスのオブジェクトを作成
        Square square = new Square(4.5, 2.8);

        // 四角形の情報を出力
        square.inform();

        // 面積の表示
        System.out.println("この四角形の面積は" + square.getArea() + "です。");

        // 幅を3.0増加させる
        square.addWidth(3.0);

        System.out.println();

        // 四角形の情報を出力
        square.inform();

        // 面積の表示
        System.out.println("この四角形の面積は" + square.getArea() + "です。");

    }
}

// 四角形Squareクラス
class Square{

	// 幅
	private double width;

	// 高さ
	private double height;

	// コンストラクタ
	public Square(double width, double height) {
		this.width = width;
		this.height = height;
	}

	// 情報出力メソッド
	public void inform() {
		System.out.println("この四角形の幅は" + width + "、高さは" +
				height + "です。");
	}

	// 面積算出メソッド
	public double getArea() {
		return width * height;
	}

	// 幅増加メソッド
	public void addWidth(double delta) {
		width += delta;
	}
}