public class Wallet extends Item{   //「お財布」行のクラス

private String who;
    Wallet(String name, String flag, String money, String who){

	    super(name, flag, money);
	    this.who = who;

	}

	public String getWho(){
		return this.who;
	}

	public String getTableParts(){
		System.out.println("Wallet:" + this.who);
    	return super.getTableParts() + this.who;
	}
}
