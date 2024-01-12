import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int [] num = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i]= Integer.parseInt(st.nextToken());
        }
        int max=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(j==i) continue;
                for(int k=0; k<N; k++){
                    if(j==k||i==k) continue;
                    if(num[i]+num[j]+num[k]<=M)
                        max = Math.max(max, num[i]+num[j]+num[k]);
                }
            }
        }
        System.out.print(max);
    }

}
