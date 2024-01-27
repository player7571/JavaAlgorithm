import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n<4){
            System.out.print(n);
            return;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int[] num = new int[222];
        for(int i=4; i<=n; i++){
            if(Math.ceil(Math.sqrt(i))==Math.floor(Math.sqrt(i))){
                dp[i] = 1;
                for(int j=0; j<num.length; j++){
                    if(num[j]==0){
                        num[j] = i;
                        break;
                    }
                }
            }
            else{
                dp[i]=dp[i-1]+1;
                for(int j=0; j<num.length; j++){
                    if(num[j]==0) break;
                    dp[i] = Math.min(dp[i], dp[i-num[j]]+dp[num[j]]);
                }
            }
        }
        System.out.print(dp[n]);
    }
}
