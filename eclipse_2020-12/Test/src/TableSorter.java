import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TableSorter {
	private Map<String, Comparator<String>> orderMap = new HashMap<>();
	public void putSortOrder(String key, Comparator<String> order) {
		orderMap.put(key, order);
	}

	public void sort(String[][] table, final OrderBy... orderBys) {
		Arrays.sort(table, new Comparator<String[]>() {
			public int compare(String[] s1, String[] s2) {
				for (OrderBy orderBy : orderBys) {
					int order = orderMap.get(orderBy.key).compare(s1[orderBy.col], s2[orderBy.col]);
					if (order != 0) {
						return orderBy.isReversed ? -order : order;
					}
				}
				return 0;
			}
		});
	}

	public static class OrderBy {
		final String key;
		final int col;
		final boolean isReversed;

		public OrderBy(String key, int col) {
			this(key, col, false);
		}

		public OrderBy(String key, int col, boolean isReversed) {
			this.key = key;
			this.col = col;
			this.isReversed = isReversed;
		}
	}
}
