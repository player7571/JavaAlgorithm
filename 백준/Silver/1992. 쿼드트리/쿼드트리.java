import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        field = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=N; j++){
                if(str.charAt(j-1)=='1') {
                    field[i][j] = true;
                }
            }
        }
        divide(1, N, 1, N);
        System.out.print(sb);

    }

    static void divide(int left, int right, int up, int down){
        for(int i=up; i<=down; i++){
            for(int j=left; j<=right; j++){
                if(field[i][j]!= field[up][left]){
                    sb.append("(");
                    divide(left, (left+right)/2, up, (up+down)/2);
                    divide((left+right)/2+1, right, up, (up+down)/2);
                    divide(left, (left+right)/2, (up+down)/2+1, down);
                    divide((left+right)/2+1, right, (up+down)/2+1, down);
                    sb.append(")");
                    return;
                }
            }
        }
        sb.append(field[up][left] ? "1" : "0");
    }
}
