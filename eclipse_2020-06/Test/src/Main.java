import java.util.Scanner;
public class Main {
  public static void main(String[] args){
	    System.out.println("積算対象の数値をカンマ切りで入力してください。");
	    String str = new Scanner(System.in).nextLine();

	    System.out.println("積算値を入力してください。");
	    double sh = new Scanner(System.in).nextDouble();

	    String[] data = str.split(",", 0);

	    for(int i = 0; i < data.length; i++ ){
	    	 System.out.println(data[i]+"×"+sh+"="+Short.parseShort(data[i])*sh);
	    }
  }
}