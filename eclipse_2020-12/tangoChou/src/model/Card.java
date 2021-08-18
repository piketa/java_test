package model;

import java.io.Serializable;

public class Card implements Serializable{
	private int id;
	private int user_id;
	private int deck_id;
	private int count = 0;
	private String question;
	private String answer;

	public Card() {}
	public Card(int user_id, int deck_id, String question, String answer) {
		this.user_id = user_id;
		this.deck_id = deck_id;
		this.question = question;
		this.answer = answer;
	}
	public Card(int id, int user_id, int deck_id, int count, String question, String answer) {
		this(user_id, deck_id, question, answer);
		this.id = id;
		this.count = count;
	}

	public int getId() {return id;}
	public int getUser_id() {return user_id;}
	public int getDeck_id() {return deck_id;}
	public int getCount() {return count;}
	public String getQuestion() {return question;}
	public String getAnswer() {return answer;}

}
