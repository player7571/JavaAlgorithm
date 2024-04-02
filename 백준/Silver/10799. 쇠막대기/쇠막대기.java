import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;
        int stick = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='('){
                if(i+1<str.length()&&str.charAt(i+1)==')'){
                    stick+=cnt;
                    i++;
                }
                else cnt++;
            }
            else {
                cnt--;
                stick++;
            }
        }
        System.out.print(stick);
    }
}
