public class ForHiLevelPractice {
    public static void main(String[] args) {

        // 山の段数を表す変数
        int level = 5;

        // for文の開始
        for(int i = 0; i < level; i++) {

        	for(int j = 0; j < level + i; j++) {

        		if(j < level - i - 1) {
        			System.out.print("　");
        		} else {
        			System.out.print("■");
        		}
        	}

        	System.out.println();
        }

        // 別の解答例
        for(int i = 0; i < level; i++) {

        	for(int j = 0; j < level - i - 1; j++) {
        		System.out.print("　");
        	}
        	for(int j = 0; j < (i * 2) + 1; j++) {
        		System.out.print("■");
        	}

        	System.out.println();
        }
    }
}