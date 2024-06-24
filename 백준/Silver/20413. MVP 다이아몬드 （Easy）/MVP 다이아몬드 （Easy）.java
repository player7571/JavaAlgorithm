import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] m = new int[4];
        for(int i=0; i<4; i++){
            m[i] = Integer.parseInt(st.nextToken());
        }
        int now = 0;
        String str = br.readLine();
        char ch = str.charAt(0);
        switch (ch){
            case 'B':
                now=m[0]-1;
                break;
            case 'S':
                now=m[1]-1;
                break;
            case 'G':
                now=m[2]-1;
                break;
            case 'P':
                now=m[3]-1;
                break;
            default:
                now = m[3];

        }
        int ans = now;
        for(int i=1; i<str.length(); i++){
            ch = str.charAt(i);
            switch (ch){
                case 'B':
                    now=m[0]-now-1;
                    break;
                case 'S':
                    now=m[1]-now-1;
                    break;
                case 'G':
                    now=m[2]-now-1;
                    break;
                case 'P':
                    now=m[3]-now-1;
                    break;
                default:
                    now=m[3];
            }
            ans+=now;
        }
        System.out.print(ans);
    }
}
