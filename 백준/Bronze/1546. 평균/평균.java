import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max=0;
        int [] grade = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int n= Integer.parseInt(st.nextToken());
            max = Math.max(max, n);
            grade[i]=n;
        }
        double avg = (double)grade[0]/max*100;
        for(int i=1; i<N; i++){
            avg += (double)grade[i]/max*100;
        }
        System.out.print(avg/N);

    }
}
