import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T= Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] cal = new int[4];
            for(int i=0; i<4; i++){
                cal[i] = Integer.parseInt(st.nextToken());
            }
            int num = cal[0]>cal[1] ? 0 : 1;
            int k=cal[num+2];
            int x = k%cal[0]==0 ? cal[0] : k%cal[0];
            int y = k%cal[1]==0 ? cal[1] : k%cal[1];
            if(x==cal[2]&&y==cal[3]) {
                sb.append(k).append("\n");
                continue;
            }
            if(num==0){
                while(k<=cal[0]*cal[1]){
                    y = k%cal[1]==0 ? cal[1] : k%cal[1];
                    if(y==cal[3]) break;
                    k+=cal[0];
                }
            }
            else{
                while(k<=cal[0]*cal[1]){
                    x = k%cal[0]==0 ? cal[0] : k%cal[0];
                    if(x==cal[2]) break;
                    k+=cal[1];
                }
            }
            if(k>cal[0]*cal[1]) sb.append("-1\n");
            else sb.append(k).append("\n");
        }
        System.out.print(sb);
    }
}
