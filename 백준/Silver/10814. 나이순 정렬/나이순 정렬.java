import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N= Integer.parseInt(br.readLine());
        String [] age = new String[1001];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            if(age[n]==null) age[n] = str;
            else age[n]= age[n]+" "+str;
        }
        for(int i=1; i<=1000; i++){
            if(age[i]!=null){
                StringTokenizer st = new StringTokenizer(age[i]);
                while(st.countTokens()!=0) sb.append(i).append(" ").append(st.nextToken()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
