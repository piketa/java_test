public class MethodBasicPractice {
    public static void main(String[] args) {

        // displayメソッドの呼び出し
        display("テスト", 5);

    }

    // ここにdisplayメソッドを定義してください
    public static void display(String message, int count) {

    	for(int i = 0; i < count; i++) {
    		System.out.println(message);
    	}

    }

}
