package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "getAllUsers", query = "SELECT u FROM User AS u ORDER BY u.ID DESC"),
		@NamedQuery(name = "getUserCount", query = "SELECT COUNT(u) FROM User AS u"),
		@NamedQuery(name = "checkRegisteredCode", query = "SELECT COUNT(u) FROM User AS u WHERE u.account = :Account"),
		@NamedQuery(name = "checkLoginAccountAndPassword", query = "SELECT u FROM User AS u WHERE u.account = :account AND u.password = :password") })
@Entity
public class User {
	// リソースの連番
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;

	// ユーザーID
	@Column(name = "account", nullable = false, unique = true)
	private String account;

	// ユーザー名
	@Column(name = "name", nullable = false)
	private String name;

	// パスワード
	@Column(name = "password", length = 64, nullable = false)
	private String password;

	// 住所
	@Column(name = "address")
	private String address;

	// 電話番号
	@Column(name = "tel", length = 11)
	private String tel;

	// 誕生日
	@Column(name = "birthday", length = 8)
	private String birthday;

	// 性別
	@Column(name = "sex")
	private String sex;

	// クレジットカード会社
	@Column(name = "credit_card_company")
	private String credit_card_company;

	// クレジットカード番号
	@Column(name = "credit_card_number", length = 16)
	private String credit_card_number;

	// 金融機関名
	@Column(name = "bank_name")
	private String bank_name;

	// 支店名
	@Column(name = "branch_name")
	private String branch_name;

	// 口座種類
	@Column(name = "account_type")
	private String account_type;

	// 口座番号
	@Column(name = "account_number", length = 7)
	private String account_number;

	// 商品登録の権限
	@Column(name = "admin_flag", nullable = false)
	private Integer admin_flag;

	// setter,getterメソッド
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		this.ID = iD;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCredit_card_company() {
		return credit_card_company;
	}

	public void setCredit_card_company(String credit_card_company) {
		this.credit_card_company = credit_card_company;
	}

	public String getCredit_card_number() {
		return credit_card_number;
	}

	public void setCredit_card_number(String credit_card_number) {
		this.credit_card_number = credit_card_number;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public Integer getAdmin_flag() {
		return admin_flag;
	}

	public void setAdmin_flag(Integer admin_flag) {
		this.admin_flag = admin_flag;
	}

}
