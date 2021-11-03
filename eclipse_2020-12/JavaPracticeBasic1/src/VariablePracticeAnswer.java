public class VariablePracticeAnswer {
	public static void main(String[] args) {

        // みかんの価格を表現するint型の変数を宣言してください。
        // （変数名はおまかせします）
		int orangePrice;

        // みかんの価格変数に130を代入してください。
		orangePrice = 130;

        // みかんの個数を表現するint型の変数を宣言し、
        // 初期値として6を代入してください。（変数名はおまかせします）
		int orangeCount = 6;

        // みかんの総価格を表現するint型の変数を宣言し、
        // 初期値に「みかん価格変数の値×みかん個数変数の値」の演算結果
        // を代入してください。（変数名はおまかせします）
		int orangeTotalPrice = orangePrice * orangeCount;

        // みかん価格変数の値を出力してください。
		System.out.println("みかんの価格：" + orangePrice + "円");

        // みかん個数変数の値を出力してください。
		System.out.println("みかんの個数：" + orangeCount + "個");

        // みかん総価格変数の値を出力してください。
		System.out.println("みかんの総価格：" + orangeTotalPrice + "円");
	}
}
