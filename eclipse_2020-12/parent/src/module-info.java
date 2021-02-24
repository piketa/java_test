module parent {
	//grandParentモジュールを読み込む
	//requires grandParent;			←コメントアウトしておきます。

	//parentプロジェクトを他のパッケージからアクセスできるようにする
	exports parent;

	//parentモジュールを読み込んだ場合はgrandParentモジュールも使えるようにする
    requires transitive grandParent;
}