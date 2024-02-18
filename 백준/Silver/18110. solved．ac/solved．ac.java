import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==0) {
            System.out.print("0");
            return;
        }
        int x= Math.round((float) (n * 15) /100);
        int[] difficulty = new int[31];
        for(int i=0; i<n; i++){
            difficulty[Integer.parseInt(br.readLine())]++;
        }
        int min= 1;
        int max= 30;
        for(int i=0; i<x; i++){
            while(difficulty[min]==0) min++;
            while(difficulty[max]==0) max--;
            difficulty[min]--;
            difficulty[max]--;
        }
        int ans = 0;
        for(int i=1; i<=30; i++){
            ans+=(i*difficulty[i]);
        }
        System.out.print(Math.round((float) ans /(n-x*2)));
    }
}
