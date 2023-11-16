package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Employee;


public class EmployeeDAO {
	//�f�[�^�x�[�X�ڑ��Ɏg�p������
	private final String JDBC_URL =
			"jdbc:mysql://localhost/tsubu";
	private final String DB_USER = "root";
	private final String DB_PASS = "honowaka40";
	
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		
		//�f�[�^�x�[�X�֐ڑ�
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			
		//SELECT��������
			String sql = "SELECT ID, NAME, AGE FROM EMPLOYEE";
			PreparedStatement pStmt = conn.prepareStatement(sql);
		//SELECT�������s���A���ʕ\���擾
			ResultSet rs = pStmt.executeQuery();
			
			//���ʕ\�Ɋi�[���ꂽ���R�[�h�̓��e��
			//Employee�C���X�^���X�ɐݒ肵�AArrayList�C���X�^���X�ɒǉ�
			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
			
			
			
		}
	}

