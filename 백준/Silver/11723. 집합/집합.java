import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        boolean[] S = new boolean[21];
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int x=0;
            if(st.countTokens()!=0) x = Integer.parseInt(st.nextToken());
            switch (str){
                case "add":
                    S[x]=true;
                    break;
                case"remove":
                    S[x]=false;
                    break;
                case"check":
                    sb.append(S[x] ? "1\n" : "0\n");
                    break;
                case"toggle":
                    S[x]=!S[x];
                    break;
                case"all":
                    for(int k=1; k<21; k++) S[k] = true;
                    break;
                default:
                    for(int k=1; k<21; k++) S[k] = false;
            }
        }
        System.out.print(sb);
    }
}
