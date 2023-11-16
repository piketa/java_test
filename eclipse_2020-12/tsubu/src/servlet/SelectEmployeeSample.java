package servlet;

import java.util.List;
import model.Employee;
import dao.EmployeeDAO;

public class SelectEmployeeSample {
	public static void main(String[] args) {
		// employee�e�[�u���̑S���R�[�h���擾
		EmployeeDAO empDAO = new EmployeeDAO();
		List<Employee> empList = empDAO.findAll();
		
		//�擾�������R�[�h�̓��e���o��
		for(Employee emp : empList) {
			System.out.println("ID:" + emp.getId());
			System.out.println("���O�F" + emp.getName());
			System.out.println("�N��F" + emp.getAge() + "\n");
		}
		}
				
	}
 
