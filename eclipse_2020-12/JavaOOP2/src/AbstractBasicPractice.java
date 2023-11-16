public class AbstractBasicPractice {
    public static void main(String[] args) {

        // 3匹の動物たちを表すAnimal配列型変数animalsの宣言と
        // 配列オブジェクトの生成
    	Animal[] animals = new Animal[3];

        // 動物たち配列変数の各要素に、順番に犬・猫・鳥
        // オブジェクトを生成・代入
    	animals[0] = new Dog();
    	animals[1] = new Cat();
    	animals[2] = new Birdd();

        // forループを使って動物たち配列変数を順にみていき、
        // 各動物の歌うsingメソッドの呼び出し
    	for(int i = 0; i < animals.length; i++) {
    		animals[i].sing();
    	}

    }
}

// 動物クラス
abstract class Animal {
    public abstract void sing();
}

// 犬クラス
class Dog extends Animal {
	public void sing() {
		System.out.println("わんわん");
	}
}

// 猫クラス
class Cat extends Animal {
	public void sing() {
		System.out.println("にゃーにゃー");
	}
}

// 鳥クラス
class Birdd extends Animal {
	public void sing() {
		System.out.println("ぴよぴよ");
	}
}