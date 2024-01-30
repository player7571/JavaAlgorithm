import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        int[] ACGT = new int[4];
        int cnt = 0;
        for(int i=0; i<4; i++){
            ACGT[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<P; i++){
            switch (str.charAt(i)){
                case 'A':
                    ACGT[0]--;
                    break;
                case'C':
                    ACGT[1]--;
                    break;
                case'G':
                    ACGT[2]--;
                    break;
                default:
                    ACGT[3]--;
            }
        }
        for(int j=0; j<5; j++){
            if(j==4) {
                cnt++;
                break;
            }
            if(0<ACGT[j]) break;
        }
        for(int i=0; i<S-P; i++){
            switch (str.charAt(i)){
                case 'A':
                    ACGT[0]++;
                    break;
                case'C':
                    ACGT[1]++;
                    break;
                case'G':
                    ACGT[2]++;
                    break;
                default:
                    ACGT[3]++;
            }
            switch (str.charAt(i+P)){
                case 'A':
                    ACGT[0]--;
                    break;
                case'C':
                    ACGT[1]--;
                    break;
                case'G':
                    ACGT[2]--;
                    break;
                default:
                    ACGT[3]--;
            }
            for(int j=0; j<5; j++){
                if(j==4) {
                    cnt++;
                    break;
                }
                if(0<ACGT[j]) break;
            }
        }
        System.out.print(cnt);
    }
}
