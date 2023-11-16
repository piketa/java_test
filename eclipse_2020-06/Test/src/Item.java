public class Item{       //おこづかい帳の行の基底クラス
	private String name;
	private String flag;
	private String money;

	Item(String name, String flag, String money){

		this.name = name;
		this.flag = flag;
		this.money = money;

	}

    public String getName(){

		return this.name;

	}

	public String getFlag(){

    	return this.flag;
	}

	public String getMoney(){

		return this.money;

    }



	public String getTableParts(){

		return this.name + "," +this.flag + "," + this.money + "," ;

	}


}
