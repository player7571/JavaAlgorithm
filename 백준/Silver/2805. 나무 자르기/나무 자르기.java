import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] tree = new int[N];
        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);
        int max = tree[N-1];
        int min = 0;
        int mid;
        while(true){
            long sum=0;
            mid = (min+max)/2;
            for(int i=N-1; i>=0; i--){
                if(tree[i]-mid<0) break;
                sum+= (tree[i] - mid);
                if(sum>M) break;
            }
            if(sum==M) break;
            else if(sum>M){
                min=mid+1;
            }
            else{
                max=mid-1;
            }
//            System.out.println(mid+" max"+max+" min"+min);
            if(min>max&&sum>M) break;
        }
        System.out.print(mid);
    }
}
