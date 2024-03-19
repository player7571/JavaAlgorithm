import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        if(str.equals("0")) {
            System.out.print(0);
            return;
        }
        switch(str.charAt(0)){
            case'0':
                break;
            case'1':
                sb.append("1");
                break;
            case'2':
                sb.append("10");
                break;
            case'3':
                sb.append("11");
                break;
            case'4':
                sb.append("100");
                break;
            case'5':
                sb.append("101");
                break;
            case'6':
                sb.append("110");
                break;
            default:
                sb.append("111");
        }
        for(int i=1; i<str.length(); i++){
            switch(str.charAt(i)){
                case'0':
                    sb.append("000");
                    break;
                case'1':
                    sb.append("001");
                    break;
                case'2':
                    sb.append("010");
                    break;
                case'3':
                    sb.append("011");
                    break;
                case'4':
                    sb.append("100");
                    break;
                case'5':
                    sb.append("101");
                    break;
                case'6':
                    sb.append("110");
                    break;
                default:
                    sb.append("111");
            }
        }
        System.out.print(sb);
    }
}
