import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class BookOfMoney{
    public static void main(String[] args)  throws IOException{


	    BookOfMoney bookOfMoney = new BookOfMoney();

        outside:while(true){

            System.out.println("\n1:収入・支出入力 \n2:データロード3  \n3:終了" ); //機能入力
            System.out.println("\n選択したい機能の番号を入力してください");
  	        Scanner sc1 = new Scanner(System.in);

 	        int function = sc1.nextInt();

	   	    switch(function){
	   	        case 1:   //収入・支出入力
    	        bookOfMoney.syushi();
                break;

		        case 2:   //データロード
		   	    bookOfMoney.dataroad();
		   	 	break;

	   	    	case 3:    //終了
		   	    break outside;

	   	        default:
	   	        System.out.println("エラー");
	        }
        }

    }


    public void syushi(){  //収支・支出入力

        int number = 0;

        String[] name = new String[number + 1];
        String[] flag = new String[number + 1];
        String[] money = new String[number + 1];
        String[] addition  = new String[number +1];
        try{
	        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
	        System.out.println("<<収入・支出入力>>\n");
	        Scanner sc2 = new Scanner(System.in);

            System.out.println("以下から選択したい名目を入力してください");
            System.out.println("お財布  食費  書籍  日用品費");
            name[number] = sc2.nextLine();
            System.out.println("\n収入の場合は「収」、支出の場合は「支」と入力してください");
            flag[number] = sc2.nextLine();
            System.out.println("\n金額(数字のみ)を入力してください");
            money[number] = sc2.nextLine();

      	    if(name[number].equals("お財布")){
        	    System.out.println("\n「誰から」を入力してください");
        	    addition[number] = sc2.nextLine();
        	}else if(name[number].equals("食費")){
        	    System.out.println("\n「店名」を入力してください。無い場合は「N/A」と入力してください");
        	 	addition[number] = sc2.nextLine();
        	}


        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("例外が発生しました");
        }

        try{
	        FileOutputStream fos = new FileOutputStream("MoneyData.txt",true);
	        OutputStreamWriter osw = new OutputStreamWriter(fos,"SHIFT_JIS");{
            osw.write(name[number] + ",");
            osw.write(flag[number] + ",");
            osw.write(money[number] + ",");
            osw.write(addition[number] + "\n");
            osw.flush();
            osw.close();
      	    number = number + 1;

	        }

        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
    }
    List<Item> list = new ArrayList<Item>();
	public void dataroad() {   //データロード

	   	    System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
		    System.out.println("<<データロード>>\n");
	   	    try{
		        FileInputStream fs = new FileInputStream("MoneyData.txt");
		        InputStreamReader isr = new InputStreamReader(fs, "SHIFT_JIS");
		        BufferedReader br = new BufferedReader(isr);
		        String textfile;
		        String[ ] splitLine = new String[4];

		  		while((textfile = br.readLine()) != null) {

		            splitLine = textfile.split( ",", 0 );



		  		 	if( splitLine[0].equals( "お財布" )){
		  		 		list.add(new Wallet(splitLine[0], splitLine[1], splitLine[2], splitLine[3] ));
	                }else if( splitLine[0].equals( "食費" )){
	                	//list.add(new FoodExpences(splitLine[0], splitLine[1], splitLine[2], splitLine[3] ));
	                }


		  		 	}

	   	    	br.close();


	        }catch (IOException e) {
	            e.printStackTrace();
	        }

	        System.out.println(list.size());
	        System.out.println(list);
	        System.out.println(list.get(0));
		    list.get(0).getTableParts();
		    list.get(1).getTableParts();


	        System.out.println("データロードが完了しました");

		    System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");

	}
}