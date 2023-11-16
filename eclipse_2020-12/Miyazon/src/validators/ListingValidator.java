package validators;

import java.util.ArrayList;
import java.util.List;

import models.Listing;

public class ListingValidator {
	public static List<String> validate(Listing l) {
		List<String> errors = new ArrayList<String>();
		String product_name_error = _validateProduct_name(l.getProduct_name());
		if (!product_name_error.equals("")) {
			errors.add(product_name_error);
		}
		String introduction_error = _validateIntroduction(l.getIntroduction());
		if (!introduction_error.equals("")) {
			errors.add(introduction_error);
		}
		return errors;
	}

	private static String _validateProduct_name(String product_name) {
		if (product_name == null || product_name.equals("")) {
			return "商品名を入力してください。";
		}
		return "";
	}

	private static String _validateIntroduction(String introduction) {
		if (introduction == null || introduction.equals("")) {
			return "商品説明を入力してください。";
		}
		return "";
	}
}
