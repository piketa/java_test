package validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.User;
import utils.DBUtil;

public class UserValidator {
	public static List<String> validate(User u, Boolean code_duplicate_check_flag, Boolean password_check_flag) {
		List<String> errors = new ArrayList<String>();
		String code_error = _validateCode(u.getAccount(), code_duplicate_check_flag);
		if (!code_error.equals("")) {
			errors.add(code_error);
		}
		String name_error = _validateName(u.getName());
		if (!name_error.equals("")) {
			errors.add(name_error);
		}
		String password_error = _validatePassword(u.getPassword(), password_check_flag);
		if (!password_error.equals("")) {
			errors.add(password_error);
		}
		return errors;
	}

	// ユーザーID
	private static String _validateCode(String UserID, Boolean code_duplicate_check_flag) {
		// 必須入力チェック
		if (UserID == null || UserID.equals("")) {
			return "ユーザーIDを入力してください。";
		}
		// すでに登録されているユーザーIDとの重複チェック
		if (code_duplicate_check_flag) {
			EntityManager em = DBUtil.createEntityManager();
			long users_count = (long) em.createNamedQuery("checkRegisteredCode", Long.class)
					.setParameter("UserID", UserID).getSingleResult();
			em.close();
			if (users_count > 0) {
				return "入力されたユーザーIDはすでに存在しています。";
			}
		}
		return "";
	}

	// ユーザー名の必須入力チェック
	private static String _validateName(String name) {
		if (name == null || name.equals("")) {
			return "ユーザー名を入力してください。";
		}
		return "";
	}

	// パスワードの必須入力チェック
	private static String _validatePassword(String password, Boolean password_check_flag) {
		// パスワードを変更する場合のみ実行
		if (password_check_flag && (password == null || password.equals(""))) {
			return "パスワードを入力してください。";
		}
		return "";
	}
}
