public class ArrayBasicPractice {
    public static void main(String[] args) {

        // 1. int配列型変数の宣言
    	int[] arr;

        // 2. 配列オブジェクトの生成
    	arr = new int[3];

        // 3. 各要素の値を代入
    	arr[0] = 25;
    	arr[1] = 39;
    	arr[2] = 43;

        // 4. 各要素の値を表示
    	for(int i = 0; i < arr.length; i++) {
    		System.out.println((i + 1) + "番目の値は" + arr[i] + "です");
    	}

    }
}
