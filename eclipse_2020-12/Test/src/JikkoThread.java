public class JikkoThread {
	public static void main(String[] args) {
		TestRun tr = new TestRun();
		Thread t1 = new Thread(tr, "Tr-1");
		Thread t2 = new Thread(tr, "Tr-2");
		Thread t3 = new Thread(tr, "Tr-3");

		t1.start();
		for(int i = 0; i < 1000000; i++);
		t2.start();
		for(int i = 0; i < 1000000; i++);
		t3.start();
	}
}
