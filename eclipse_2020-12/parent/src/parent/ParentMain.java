package parent;

import grandParent.HelloGrandParent;

public class ParentMain {

	public static void main(String[] args) {
		HelloGrandParent hgp = new HelloGrandParent();
		hgp.hello();
	}

}
