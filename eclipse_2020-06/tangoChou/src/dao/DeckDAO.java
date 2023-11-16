package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Deck;

public class DeckDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/tangoChou";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public void createDeck(Deck deck) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "INSERT INTO DECK VALUES (" + deck.getId() + "," + deck.getUser_id() + ","
						 + deck.getDate() + ")";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		int rs = pStmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Deck> getDecks(int user_id) {
		ArrayList<Deck> decks = new ArrayList<Deck>();
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT * FROM DECK WHERE USER_ID = " + user_id;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String date = rs.getString("Date");
				Deck deck = new Deck(id, user_id, date);
				decks.add(deck);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return decks;
	}
}
