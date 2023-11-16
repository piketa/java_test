public class ForBasicPractice {
    public static void main(String[] args) {

        // for文の開始
    	// 21から29までのループ
    	for(int i = 21; i <= 29; i++) {

    		// 3から9までの倍数か調査するためのループ
    		for(int j = 3; j <= 9; j++) {

    			// もし割った余りが0ならその倍数
    			if(i % j == 0) {
    				System.out.println(i + "は" + j + "の倍数です");
    			}
    		}
    	}

    }
}