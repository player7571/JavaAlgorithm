import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dice = new int[N][6];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++){
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] sum = new int[6];
        for(int k=0; k<6; k++){
            int bottom = dice[0][k];
            for(int i=0; i<N; i++){
                boolean[] chk = new boolean[6];
                int max = 0;
                for(int j=0; j<6; j++){
                    if(dice[i][j]==bottom) {
                        switch (j){
                            case 0:
                                chk[0] = true;
                                chk[5] = true;
                                bottom = dice[i][5];
                                break;
                            case 1:
                                chk[1] = true;
                                chk[3] = true;
                                bottom = dice[i][3];
                                break;
                            case 2:
                                chk[2] = true;
                                chk[4] = true;
                                bottom = dice[i][4];
                                break;
                            case 3:
                                chk[3] = true;
                                chk[1] = true;
                                bottom = dice[i][1];
                                break;
                            case 4:
                                chk[4] = true;
                                chk[2] = true;
                                bottom = dice[i][2];
                                break;
                            default:
                                chk[5] = true;
                                chk[0] = true;
                                bottom = dice[i][0];
                        }
                        break;
                    }
                }
                for(int j=0; j<6; j++){
                    if(chk[j]) continue;
                    max = Math.max(max, dice[i][j]);
                }
                sum[k] +=max;
            }
        }
        int result=0;
        for(int s : sum){
            result = Math.max(result, s);
        }
        System.out.print(result);
    }
}
