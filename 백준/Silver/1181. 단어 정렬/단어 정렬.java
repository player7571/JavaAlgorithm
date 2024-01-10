import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String [] word = new String[51];
        for(int i=0; i<N; i++) {
            String w = br.readLine();
            int len = w.length();
            if (word[len] != null) word[len] = word[len]+" "+w;
            else word[len] = w;
        }
        for(int i=1; i<51; i++){
            if(word[i]!=null) {
                StringTokenizer st = new StringTokenizer(word[i]);
                String[] w = new String[st.countTokens()];
                for(int j=0; j<w.length; j++){
                    w[j]=st.nextToken();
                }
                Arrays.sort(w);
                for(int j=0; j<w.length; j++){
                    if(j<w.length-1 && w[j].equals(w[j+1])) continue;
                    sb.append(w[j]).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
