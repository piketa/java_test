
abstract class Test {
	public static void main(String[] args) {
		TestAb a = new TestSub();

	}
}

abstract class TestAb {

}

class TestSub extends TestAb {
	public void sing() {
		System.out.println("わんわん");
	}
}

