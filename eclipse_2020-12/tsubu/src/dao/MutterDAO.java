package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Mutter;

public class MutterDAO {
	//�f�[�^�x�[�X�ڑ��Ɏg�p������
	private final String JDBC_URL =
			"jdbc:mysql://localhost:3306/tsubu";
	private final String DB_USER = "root";
	private final String DB_PASS = "honowaka40";
	
	
	public List<Mutter> findAll() {
		List<Mutter> mutterList = new ArrayList<>();
		
		//�f�[�^�x�[�X�ڑ�
		try(Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT���̏���
			String sql =
					"SELECT ID,NAME,TEXT FROM MUTTER ORDER BY ID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SELECT�����s
			ResultSet rs = pStmt.executeQuery();
			
			// SELECT���̌��ʂ�ArrayList�Ɋi�[
			while (rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
			}
		  } catch (SQLException e) {
			  e.printStackTrace();
			  return null;
		}
		return mutterList;
	}
	
	
	public boolean create(Mutter mutter) {
		//�f�[�^�x�[�X�ڑ�
		try(Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			
		// INSERT���̏����iid�͎����A�ԂȂ̂Ŏw�肵�Ȃ��Ă悢�j
		String sql = "INSERT INTO MUTTER(NAME, TEXT) VALUES(?, ?)";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		
		// INSERT�����́u�H�v�Ɏg�p����l��ݒ肵SQL������
		pStmt.setString(1, mutter.getUserName());
		pStmt.setString(2, mutter.getText());
		
		// INSERT�������s�iresult�ɂ͒ǉ����ꂽ�s������������j
		int result = pStmt.executeUpdate();
		if (result != 1) {
			return false;
		}
	   } catch(SQLException e) {
		   e.printStackTrace();
		   return false;
		
		}
		return true;
	}

}
