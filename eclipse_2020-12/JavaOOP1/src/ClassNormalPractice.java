public class ClassNormalPractice {
    public static void main(String[] args) {

        // Personクラスのオブジェクトを作成
        Person[] persons = { new Person(), new Person(), new Person() };

        // Personオブジェクトに氏名と年齢をセット
        persons[0].setData("大島", 30);
        persons[1].setData("村上", 30);
        persons[2].setData("黒沢", 32);

        // 自己紹介
        for(int i = 0; i < persons.length; i++) {
            persons[i].introduce();
        }

        System.out.println();

        // 年齢差をチェック
        persons[0].compare(persons[1]);
        persons[1].compare(persons[2]);
        persons[2].compare(persons[1]);

    }
}

// Personクラス
class Person {

	// 名前
	private String name;

	// 年齢
	private int age;

	// オブジェクトにデータをセットする
	public void setData(String name, int age) {
		this.age = age;
		this.name = name;
	}

	// 年齢取得メソッド
	public int getAge() {
		return age;
	}

	// 名前取得メソッド
	public String getName() {
		return name;
	}

	// 自己紹介メソッド
	public void introduce() {
		System.out.println("わたしの名前は" + name + "、" +
				"年齢は" + age + "歳です。");
	}

	// 年齢差比較メソッド
	public void compare(Person person) {

		// 自分の方が年上の場合
		if(age > person.getAge()) {
			System.out.println("わたくし" + name + "は、" +
					person.getName() + "さんより" +
					(age - person.getAge()) +
					"歳年上です。");
		}
		// 自分の方が年下の場合
		else if(age < person.getAge()) {
			System.out.println("わたくし" + name + "は、" +
					person.getName() + "さんより" +
					(person.getAge() - age) +
					"歳年下です。");
		}
		// 同じ年齢の場合
		else {
			System.out.println("わたくし" + name + "は、" +
					person.getName() + "さんと同じ年齢です。");
		}
	}
}