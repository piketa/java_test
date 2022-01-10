public class ClassBasicPractice {
    public static void main(String[] args) {

        // 1匹目のペットオブジェクトの生成
        Pet pet1 = new Pet();

        // 1匹目のペットデータを設定
        pet1.setType("犬");
        pet1.setName("コタロー");
        pet1.setAge((byte)4);
        pet1.setGender(false);

        // 2匹目のペットオブジェクトの生成
        Pet pet2 = new Pet();

        // 2匹目のペットのデータを設定
        pet2.setType("猫");
        pet2.setName("ミー");
        pet2.setAge((byte)2);
        pet2.setGender(true);

        // 2匹のペットの紹介文を取得し、表示する
        System.out.println(pet1.getIntroduction());
        System.out.println(pet2.getIntroduction());

    }
}

// Petクラス
class Pet {

	// タイプ
	private String type;

	// 名前
	private String name;

	// 年齢
	private byte age;

	// 性別（true:メス false:オス）
	private boolean gender;

	// 種類を設定する
	public void setType(String type) {
		this.type = type;
	}

	// 名前を設定する
	public void setName(String name) {
		this.name = name;
	}

	// 年齢を設定する
	public void setAge(byte age) {
		this.age = age;
	}

	// 性別を設定する
	public void setGender(boolean gender) {
		this.gender = gender;
	}

	// 紹介文を取得する
	public String getIntroduction() {
		String tmp;

		tmp = type + "の" + name + "は";

		if(gender) {
			tmp += "メス";
		} else {
			tmp += "オス";
		}

		tmp += "で" + age + "歳です。";

		return tmp;
	}
}
