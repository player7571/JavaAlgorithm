import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] val = new int[4];
        for(int i=0; i<3; i++){
            val[i] = Integer.parseInt(st.nextToken());
        }
        if(val[1]>=val[2]) {
            System.out.print("-1");
            return;
        }
        val[3]=val[0]/(val[2]-val[1])+1;
        System.out.print(val[3]);
    }
}
