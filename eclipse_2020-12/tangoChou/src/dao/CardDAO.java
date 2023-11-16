package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Card;

public class CardDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/tangoChou";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public  Card getCard(int id) {
		Card card = new Card();
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT * FROM CARD WHERE ID = " + id;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			rs.next();
			int user_id = rs.getInt("USER_ID");
			int deck_id = rs.getInt("DECK_ID");
			int count = rs.getInt("COUNT");
			String question = rs.getString("QUESTION");
			String answer = rs.getString("ANSWER");

			card = new Card(id, user_id, deck_id, count, question, answer);

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return card;
	}

	public List<Card> getCards(int deck_id){
		ArrayList<Card> cards = new ArrayList<Card>();
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT * FROM CARD WHERE DECK_ID = " + deck_id;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				int user_id = rs.getInt("USER_ID");
				int count = rs.getInt("COUNT");
				String question = rs.getString("QUESTION");
				String answer = rs.getString("ANSWER");

				Card card = new Card(id, user_id, deck_id, count, question, answer);
				cards.add(card);
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cards;
	}

	public void createCard(Card card) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			CardDAO dao = new CardDAO();
			int id = dao.newId();

			String sql = "INSERT INTO CARD VALUES (" + id + "," + card.getUser_id() + ","
						 + card.getDeck_id() + "," + 0  + "," + "\'" + card.getQuestion() + "\',"
						 + "\'" + card.getAnswer() + "\')";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		int rs = pStmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int newId() {
		int newId = 0;
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT MAX(ID) AS MAXID FROM CARD";
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

	public void edit(int card_id, String question, String answer) {
		if(question == null || question.equals("")) {
			try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
				String sql = "UPDATE CARD SET ANSWER = \'" + answer + "\' WHERE ID = " + card_id;
				PreparedStatement pStmt = conn.prepareStatement(sql);
				int rs = pStmt.executeUpdate();

			}catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(answer == null || answer.equals("")) {
			try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
				String sql = "UPDATE CARD SET QUESTION = \'" + question + "\' WHERE ID = " + card_id;
				PreparedStatement pStmt = conn.prepareStatement(sql);
				int rs = pStmt.executeUpdate();

			}catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
				String sql = "UPDATE CARD SET QUESTION = \'" + question + "\', ANSWER = \'" + answer
							 + "\' WHERE ID = " + card_id;
				PreparedStatement pStmt = conn.prepareStatement(sql);
				int rs = pStmt.executeUpdate();

			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

