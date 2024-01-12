import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int [] A = new int[N];
        int [] B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int max=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, B[i]);
        }
        int sum=0;
        boolean loop;
        for(int i=0; i<N; i++){
            loop=true;
            int num=max;
            max=0;
            for(int j=0; j<N; j++){
                if(B[j]!=-1&&B[j]==num&&loop) {
                    sum+=B[j]*A[i];
                    B[j]=-1;
                    loop=false;
                }
                max = Math.max(max, B[j]);
            }
        }
        System.out.println(sum);
    }
}
