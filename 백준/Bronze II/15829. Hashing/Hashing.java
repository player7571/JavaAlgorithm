import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int ans=0;
        for(int i=0; i<L; i++){
            ans+=((int)Math.pow(31, i)*(str.charAt(i)-'a'+1));
        }
        System.out.print(ans);
    }
}
