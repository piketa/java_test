public class NestClassBasicPractice {
    public static void main(String[] args) {

        // 学校の設立
        School school = new School("Java学園");

        // 生徒が続々と入学
        school.enterSchool("春日");
        school.enterSchool("若林");
        school.enterSchool("遠藤");
        school.enterSchool("田中");
        school.enterSchool("渡辺");

        // 定員オーバー
        school.enterSchool("山下");

        System.out.println();

        // 在校生の紹介
        school.introduce();

    }
}

// 学校クラス
class School {

	// 定員数定数
	public static final int CAPACITY = 5;

	// 学校名
	private String name;

	// 在校生配列
	private Student[] students;

	// 生徒ネストクラス
	private class Student {

		// 出席番号
		private int id;

		// 生徒名
		private String name;

		// コンストラクタ
		public Student(final int id, final String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return School.this.name + "に在学している出席番号" + id + "の" + name + "です。";
		}
	}

	// コンストラクタ
	public School(final String name) {

		this.name = name;

		// 定員分の空きを確保
		students = new Student[CAPACITY];
	}

	// 入学メソッド
	public void enterSchool(final String name) {

		for(int i = 0; i < students.length; i++) {

			// 空きがあれば
			if(students[i] == null) {
				students[i] = new Student(i + 1, name);
				System.out.println(name + "さんが" + this.name + "に入学しました");
				return;
			}
		}

		System.out.println("定員オーバーで" + name + "さんは" + this.name + "に入学できません");
	}

	// 在校生紹介メソッド
	public void introduce() {

		for(int i = 0; i < students.length; i++) {

			// 在校生がいる場合
			if(students[i] != null) {
				System.out.println(students[i]);
			} else {
				break;
			}
		}
	}
}
