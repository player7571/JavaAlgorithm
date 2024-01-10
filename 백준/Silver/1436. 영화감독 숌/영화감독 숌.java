import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num=666;
        while(true){
            char[] s = Integer.toString(num).toCharArray();
            for(int i=2; i<s.length; i++){
                if(s[i-2]=='6' && s[i-1]=='6' && s[i]=='6') {
                    N--;
                    break;
                }
            }
            if(N==0) break;
            num++;
        }
        System.out.print(num);
    }
}
