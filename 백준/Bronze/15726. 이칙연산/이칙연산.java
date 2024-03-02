import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] val = new double[3];
        for(int i=0; i<3; i++){
            val[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print((int)Math.max(val[0]*val[1]/val[2], val[0]/val[1]*val[2]));
    }
}
