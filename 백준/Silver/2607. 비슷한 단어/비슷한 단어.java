import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String word = br.readLine();
        int[] count = new int[27];
        int ans = 0;
        for(int i=0; i<word.length(); i++){
            count[word.charAt(i)-'A']++;
        }
        while (N-->1){
            String str = br.readLine();
            if(Math.abs(word.length()-str.length())>1){
                continue;
            }
            int[] cnt = new int[26];
            for(int i=0; i<str.length(); i++){
                cnt[str.charAt(i)-'A']++;
            }
            boolean bool = false;
            boolean bool2 = false;
            boolean tf = true;
            for(int i=0; i<26; i++){
                if(Math.abs(cnt[i]-count[i])==1){
                    if(bool2) {
                        tf = false;
                        break;
                    }
                    if(bool) {
                        bool2 = true;
                    }
                    bool = true;
                }
                else if(Math.abs(cnt[i]-count[i])>1){
                    tf = false;
                    break;
                }
            }
            if(tf) ans++;
        }
        System.out.print(ans);
    }
}
