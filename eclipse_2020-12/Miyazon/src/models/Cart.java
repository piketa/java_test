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

@Table(name = "carts")
@NamedQueries({ @NamedQuery(name = "getAllCart", query = "SELECT c FROM Cart AS c ORDER BY c.id DESC"),
		@NamedQuery(name = "getCartCount", query = "SELECT COUNT(c) FROM Cart AS c"),
		@NamedQuery(name = "getMyAllCart", query = "SELECT c FROM Cart AS c WHERE c.user = :user ORDER BY c.id DESC"),
		@NamedQuery(name = "getMyCartCount", query = "SELECT COUNT(c) FROM Cart AS c WHERE c.user = :user ORDER BY c.id DESC") })
@Entity
public class Cart {
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

	// 個数
	@Column(name = "number", length = 100)
	Integer number;

	// カート追加日時
	@Column(name = "created_at", nullable = false)
	private Timestamp created_at;

	// カート更新日時
	@Column(name = "updated_at", nullable = false)
	private Timestamp updated_at;

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

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
}
