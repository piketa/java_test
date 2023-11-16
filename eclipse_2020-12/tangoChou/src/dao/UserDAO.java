package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/tangoChou";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public Integer login(User user) {
		Integer id = Integer.valueOf(0);
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT ID FROM USER WHERE EMAIL = \'" + user.getEmail()
						 + "\' AND PASSWORD = \'" + user.getPass() + "\'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			rs.next();
			id = Integer.valueOf(rs.getInt("ID"));

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public boolean checkEmail(String email) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT EMAIL FROM USER WHERE EMAIL = \'" + email + "\'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			rs.next();
			String check = rs.getString("EMAIL");

		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean signup(User user) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			UserDAO dao = new UserDAO();
			int id = dao.newId();

			String sql = "INSERT INTO USER VALUES (" + id + ",\'"
						 + user.getEmail() + "\',\'" + user.getPass() + "\')";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			int rs = pStmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int newId() {
		int newId = 0;
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT MAX(ID) AS MAXID FROM USER";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			rs.next();
			newId = rs.getInt("MAXID");
			newId++;

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return newId;
	}
}
