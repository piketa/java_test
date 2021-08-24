
/*削除確認*/
function Check(){
	var checked = confirm("削除してもよろしいですか？");
		if (checked == true) {
			return true;
		}else{
			return false;
		}
	}

/*日付入力フォームの初期値設定*/
    var date = new Date();

    var yyyy = date.getFullYear();
    var mm = ("0"+(date.getMonth()+1)).slice(-2);
    var dd = ("0"+date.getDate()).slice(-2);
    document.getElementById("today").value=yyyy+'-'+mm+'-'+dd;	