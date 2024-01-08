import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int [] dot = new int [4];
        int [] p = new int [3];
        int check = 0, count = 0;
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                dot[j] = Integer.parseInt(st.nextToken());
            }
            int n = Integer.parseInt(br.readLine());
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k =0; k<3; k++){
                    p[k] = Integer.parseInt(st.nextToken());
                }
                if(Math.pow(p[0]-dot[0], 2)+Math.pow(p[1]-dot[1], 2) < Math.pow(p[2], 2)){
                    if(Math.pow(p[0]-dot[2], 2)+Math.pow(p[1]-dot[3], 2) != Math.pow(p[2], 2)) check++;
                }
                if(Math.pow(p[0]-dot[2], 2)+Math.pow(p[1]-dot[3], 2) < Math.pow(p[2], 2)){
                    if((Math.pow(p[0]-dot[0], 2)+Math.pow(p[1]-dot[1], 2) != Math.pow(p[2], 2))) check++;
                }
                if(check==1) count++;
                check = 0;
            }
            if(i!=T-1) sb.append(count).append("\n");
            else sb.append(count);
            count=0;
        }
        System.out.println(sb);
    }
}
