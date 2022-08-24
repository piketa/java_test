import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorSample {
	public static void main(String[] args) {
		List<Employee> memberLists = new ArrayList<>();
		memberLists.add(new Employee(50, "TANAKA"));
		memberLists.add(new Employee(40, "HASHIMOTO"));
		memberLists.add(new Employee(20, "SAITOH"));
		memberLists.add(new Employee(10, "ITOH"));
		memberLists.add(new Employee(30, "SUZUKI"));

		//ID並び替え用
		Comparator<Employee> c1 = (e1, e2) -> {
			return e1.getId() - e2.getId();
		};

		//名前並び替え用
		Comparator<Employee> c2 = (e1, e2) -> {
			return e1.getName().compareTo(e2.getName());
		};

		System.out.println("ID順----------");
		dispData(memberLists, c1);

		System.out.println("名前順----------");
		dispData(memberLists, c2);
}

	private static void dispData(List<Employee> list, Comparator<Employee> c) {
		System.out.println(list);
		Collections.sort(list, c);
		list.forEach(emp -> System.out.println(emp.getId() + ":" + emp.getName()));
//		Employee emp = new Employee(50, "TANAKA");
		System.out.println(list);
		list.forEach(Employee::dispTest);
	}
}
