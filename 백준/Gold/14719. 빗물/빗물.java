import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] field = new int[m];
        int max = 0;
        int ans = n*m;
        for(int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            field[i] = num;
            ans -= num;
            max = Math.max(num, max);
        }
        int leftMax = field[0];
        int len = 0;
        for(int i=1; i<m; i++){
            if(leftMax==max) break;
            len++;
            if(field[i]>leftMax) {
                ans-=((max-leftMax)*len);
//                System.out.println((max-leftMax)*len);
                leftMax = field[i];
                len = 0;
            }
        }
        int rightMax = field[m-1];
        len = 0;
        for(int i=m-2; i>=0; i--){
            if(rightMax==max) break;
            len++;
            if(field[i]>rightMax) {
                ans-=((max-rightMax)*len);
//                System.out.println((max-rightMax)*len);
                rightMax = field[i];
                len = 0;
            }
        }
        ans-=((n-max)*m);
        System.out.print(ans);
    }
}
