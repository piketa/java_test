public class Question11 {
	private int id;
	private String name;
	public Question11() {
		id = 1000;
	}
	public Question11(String name) {
		id = 1000;
		this.name = name;
	}
	public void disp() {
		System.out.println("ID:" + id + " NAME:" + name);
	}
}
