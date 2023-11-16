package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "purchases")
@NamedQueries({
		@NamedQuery(name = "getMyAllPurchases", query = "SELECT p FROM Purchase AS p WHERE p.user = :user ORDER BY p.id DESC"), })
@Entity
public class Purchase {
	// リソースの連番
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// 購入者
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// 商品
	@ManyToOne
	@JoinColumn(name = "listing_id", nullable = false)
	private Listing listing;

	// 購入個数
	@Column(name = "number", length = 100, nullable = false)
	Integer number;

	// 支払い方法
	@Column(name = "pay_method", nullable = false)
	private String pay_method;

	// 作成
	@Column(name = "created_at")
	private Timestamp created_at;

	// getter,setterメソッド

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPay_method() {
		return pay_method;
	}

	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

}