import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] max = new int[2];
        for(int i=0; i<S.length(); i++){
            for(int j=1; i-j>=0&&i+j<S.length(); j++){
                if(S.charAt(i-j)!=S.charAt(i+j)) break;
                if(i+j==S.length()-1) max[0] = Math.max(max[0], j);
            }
            for(int j=1; i+1-j>=0&&i+j<S.length(); j++){
                if(S.charAt(i+1-j)!=S.charAt(i+j)) break;
                if(i+j==S.length()-1) max[1] = Math.max(max[1], j);
            }
        }
        int ans;
        if(max[0]==0&&max[1]==0) ans = S.length()*2-1;
        else if(max[0]>=max[1]) ans = S.length()+(S.length()-(max[0]*2+1));
        else ans = S.length()+(S.length()-(max[1]*2));
        System.out.print(ans);
    }
}
