import java.util.Comparator;

public class TableSorterTester {
	public static void main(String[] args) {
		String[][] data = new String[][] {
			{"apple", "3", "1,000"},
			{"cherry", "1", "1,000"},
			{"banana", "1", "300"},
			{"banana", "2", "2,000"},
			{"apple", "2", "300"}
		};
		TableSorter sorter = new TableSorter();
		sorter.putSortOrder("lex", new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		sorter.putSortOrder("num", new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		sorter.sort(data,  new TableSorter.OrderBy("lex", 0), new TableSorter.OrderBy("num", 1, true));
		for (String[] row : data) {
			for (String col : row) {
				System.out.printf("%s", col);
			}
			System.out.println();
		}
	}
}
