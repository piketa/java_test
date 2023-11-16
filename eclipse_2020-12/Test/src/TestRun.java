public class TestRun implements Runnable {
	private int judge;

	@Override
	public synchronized void run() {
		try {
			if (Thread.currentThread().getName().equals("Tr-1")) {
				System.out.println(Thread.currentThread().getName() + "がwaitします。");
				wait();
				System.out.println(Thread.currentThread().getName() + "が動き出しました。");
				System.out.println("judge の値は、" + judge + "です。");
			} else if (Thread.currentThread().getName().equals("Tr-2")) {
				System.out.println(Thread.currentThread().getName() + "がwaitします。");
				wait();
				System.out.println(Thread.currentThread().getName() + "が動き出しました。");
				System.out.println("judge の値は、" + judge + "です。");
			} else {
				judge = 10;
				System.out.println(Thread.currentThread().getName() + "がsleepします。");
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName() + "が notify をコールします。");
				notify();
				System.out.println(Thread.currentThread().getName() + "はそのまま動きます。");
			}
		} catch(InterruptedException e) {
			System.out.println(e);
		}
		System.out.println(Thread.currentThread().getName() + "が終了しました。");
	}
}
