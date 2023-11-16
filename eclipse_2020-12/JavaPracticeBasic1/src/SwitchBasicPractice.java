public class SwitchBasicPractice {
    public static void main(String[] args) {

        int month = 1;        // ←値を変更しながら実行

        System.out.println(month + "月");


        // switch文の開始
        switch(month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
        	System.out.println(month + "月は31日まであります");
        	break;
        case 4:
        case 6:
        case 9:
        case 11:
        	System.out.println(month + "月は30日まであります");
        	break;
        case 2:
        	System.out.println("2月は28、または29日まであります");
        	break;
        default :
        		System.out.println("エラー");
        		break;
        }

    }
}