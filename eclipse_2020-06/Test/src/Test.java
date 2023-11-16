public class Test {
	public static void main(String[] args) {
		int[][] ary = new int[4][2];
		System.out.println(ary.length + " " + ary[0].length + " " + ary[1].length);
		ary[0] = new int[]{10, 20, 30, 40};
		System.out.println(ary.length + " " + ary[0].length + " " + ary[1].length);
		ary[1] = new int[]{50, 60};
		System.out.println(ary.length + " " + ary[0].length + " " + ary[1].length);
	}

}
