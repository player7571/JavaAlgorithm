import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int ans = 0;
            if(ch>=100){
                ans = ch/100+(ch-100)/10+(ch%10);
            }
            else {
                ans = ch/10+(ch%10);
            }
            for(int j=0; j<ans; j++){
                sb.append(ch);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
