package models;


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

@Table(name = "listing")
@NamedQueries({ @NamedQuery(name = "getAllListing", query = "SELECT l FROM Listing AS l ORDER BY l.id DESC"),
		@NamedQuery(name = "getListingCount", query = "SELECT COUNT(l) FROM Listing AS l"),
		@NamedQuery(name = "getMyAllListing", query = "SELECT l FROM Listing AS l WHERE l.user = :user ORDER BY l.id DESC"),
		@NamedQuery(name = "getMyListingCount", query = "SELECT COUNT(l) FROM Listing AS l WHERE l.user = :user ORDER BY l.id DESC") })
@Entity
public class Listing {
	// リソースの連番
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// ユーザー名（登録者）
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// 商品名
	@Column(name = "product_name", length = 100, nullable = false)
	private String product_name;

	// 商品カテゴリー
	@Column(name = "category")
	private String category;

	// 価格
	@Column(name = "price")
	private Integer price;

	// 在庫数
	@Column(name = "stock")
	private Integer stock;

	// 商品画像
	@Column(name = "image")
	private String image;

	// 商品説明
	@Column(name = "introduction")
	private String introduction;

	// getter,setterメソッド
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
}