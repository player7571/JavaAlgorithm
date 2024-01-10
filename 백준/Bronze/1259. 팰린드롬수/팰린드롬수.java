import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String num= br.readLine();
            if(num.equals("0")) break;
            if(Integer.parseInt(num)<10&&Integer.parseInt(num)>=1) {
                sb.append("yes\n");
                continue;
            }
            boolean pl = true;
            char[] n = num.toCharArray();
            int len = n.length;
            if(len%2==1){
                for(int i=1; i<len/2+1; i++){
                    if(n[len/2+i]!=n[len/2-i]) {
                        pl = false;
                        break;
                    }
                }
            }
            else{
                for(int i=0; i<len/2; i++){
                    if(n[len/2+i]!=n[len/2-i-1]) {
                        pl = false;
                        break;
                    }
                }
            }
            if(pl) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb);
    }
}
