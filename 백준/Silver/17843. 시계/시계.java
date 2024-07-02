import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double h = Double.parseDouble(st.nextToken());
            double m = Double.parseDouble(st.nextToken());
            double s = Double.parseDouble(st.nextToken());
            h = h*30+m/2+s/120;
            m = m*6+s/10;
            s = s*6;
            double[] ans = new double[3];
            ans[0] = Math.abs(h-m);
            ans[1] = Math.abs(m-s);
            ans[2] = Math.abs(h-s);
            for(int i=0; i<3; i++){
                if(ans[i]>180) ans[i] = 360-ans[i];
            }
            sb.append(Math.min(ans[0], Math.min(ans[1], ans[2]))).append("\n");
        }
        System.out.print(sb);
    }
}
