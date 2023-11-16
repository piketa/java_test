package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Deck implements Serializable{
	private int id;
	private int user_id;
	private String date;

	public Deck() {}
	public Deck(int id,int user_id) {
		this.id = id;
		this.user_id = user_id;
	}
	public Deck(int id, int user_id, String date) {
		this(id, user_id);
		this.date = date;
	}

	public int getId() {return id;}
	public int getUser_id() {return user_id;}
	public String getDate() {return date;}
	public void setDate() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate now = LocalDate.now();
		this.date = f.format(now);
	}
}
