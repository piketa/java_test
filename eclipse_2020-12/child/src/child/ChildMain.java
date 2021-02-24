package child;

import grandParent.HelloGrandParent;
import parent.HelloParent;

public class ChildMain {

	public static void main(String[] args) {
		HelloParent hp = new HelloParent();
		hp.hello();

		//grandParentプロジェクトのメソッド
		HelloGrandParent hgp = new HelloGrandParent();
		hgp.hello();
	}

}
