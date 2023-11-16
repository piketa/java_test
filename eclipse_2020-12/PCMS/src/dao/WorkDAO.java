package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Work;

/**
 *@author Akihiro Nakamura
 *作業テーブルに接続するDAOクラス
 */
public class WorkDAO {

	/**
	 *特定のデータベースとの接続
	 */
	private Connection con;

	/**
	 *SQL文の解析と実行
	 */
	private PreparedStatement ps;

	/**
	 *SQL実行結果の取得
	 */
	private ResultSet rs;

	/**
	 *@throws SQLException データベース接続処理でエラー
	 *データベースと接続するメソッド
	 */
	public void dbConnect() throws SQLException {
		ConnectionManager cm = new ConnectionManager();
		con = cm.connect();
	}

	/**
	 *@throws SQLException データベース切断処理でエラー
	 *データベースとの接続を切断するメソッド
	 */
	public void dbClose() throws SQLException {
		ConnectionManager cm = new ConnectionManager();
		con = cm.close();
	}

	/**
	 *リストに格納
	 */
	private List<Work> wlist = new ArrayList<>();

	/**
	 *@param department_id 部署ID
	 *@return List<Work> 作業項目一覧
	 *@throws SQLException データベース接続処理でエラー
	 *部署毎の作業項目を取得するメソッド
	 */
	public List<Work> selectTask(String department_id) throws SQLException{

		//初期化
		Work work = null;

		//データベースから部署毎の作業内容を取得するSQL文
		String sql ="select * from works where department_id = ?";
		ps = con.prepareStatement(sql);

		//プレースホルダに値をセット
		ps.setString(1,department_id);

		//SQL文の実行
		rs = ps.executeQuery();

		while(rs.next()){

			//データベースから取得した値をセット
			work = new Work();

			//部署ID
			work.setDepartment_Id(rs.getString("department_id"));
			//作業内容
			work.setTask(rs.getString("task"));

			wlist.add(work);
		}
		return wlist;
	}

	/**
	 *@param department_id	部署ID
	 *@param task	作業項目
	 *@return データベースに作業項目を追加登録出来たらtrue,出来なかったらfalse
	 *@throws SQLException データベース接続処理でエラー
	 *作業項目を追加登録するメソッド
	 */
	public boolean addTask(String department_id,String task) throws SQLException{

		//オートコミットの無効
		con.setAutoCommit(false);

		//追加登録判定
		boolean addJudge = false;

		//データベースに作業内容を追加登録するSQL文
		String sql = "insert into db_works (department_id,task) values (?,?)";
		ps = con.prepareStatement(sql);

		//プレースホルダに値をセット
		//部署ID
		ps.setString(1,department_id);
		//作業内容
		ps.setString(2,task);

		//SQL文の実行
		int at = ps.executeUpdate();

		//追加登録したらコミットする
		if(at > 0){
			addJudge = true;
			con.commit();
		}
		return addJudge;
	}

	/**
	 *@param task 作業項目
	 *@return 指定した作業項目を削除出来たらtrue,出来なかったらfalse
	 *@throws SQLException データベース接続処理でエラー
	 *作業項目を削除するメソッド
	 */
	public boolean deleteTask(String task) throws SQLException{

		//オートコミットの無効
		con.setAutoCommit(false);

		//データベースから作業項目を削除するSQL文
		String sql = "delete from works where task = ?";
		ps = con.prepareStatement(sql);

		//削除判定
		boolean deleteJudge = false;

		//プレースホルダに値をセット
		//作業項目
		ps.setString(1,task);

		//SQL文の実行
		int dt = ps.executeUpdate();

		//削除したらコミットする
		if(dt > 0){
			deleteJudge = true;
			con.commit();
		}
		return deleteJudge;
	}
}
