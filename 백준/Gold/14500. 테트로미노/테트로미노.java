import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] field;
    static int N;
    static int M;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                I(i, j);
                O(i, j);
                L(i, j);
                S(i, j);
                T(i, j);
            }
        }
        System.out.print(max);

    }
    static void I(int n, int m){
        if(n+3<N) max = Math.max(field[n][m]+field[n+1][m]+field[n+2][m]+field[n+3][m], max);
        if(m+3<M) max = Math.max(field[n][m]+field[n][m+1]+field[n][m+2]+field[n][m+3], max);
    }
    static void O(int n, int m){
        max = Math.max(n+1<N&&m+1<M ? field[n][m]+field[n+1][m]+field[n][m+1]+field[n+1][m+1] : 0, max);
    }
    static void L(int n, int m){
        if(n+2<N&&m+1<M) {
            max = Math.max(field[n][m]+field[n+1][m]+field[n+2][m]+field[n+2][m+1], max);
            max = Math.max(field[n][m]+field[n+1][m]+field[n+2][m]+field[n][m+1], max);
            max = Math.max(field[n][m+1]+field[n+1][m+1]+field[n+2][m+1]+field[n+2][m], max);
            max = Math.max(field[n][m+1]+field[n+1][m+1]+field[n+2][m+1]+field[n][m], max);
        }
        if(n+1<N&&m+2<M) {
            max = Math.max(field[n][m]+field[n][m+1]+field[n][m+2]+field[n+1][m+2], max);
            max = Math.max(field[n][m]+field[n][m+1]+field[n][m+2]+field[n+1][m], max);
            max = Math.max(field[n+1][m]+field[n+1][m+1]+field[n+1][m+2]+field[n][m+2], max);
            max = Math.max(field[n+1][m]+field[n+1][m+1]+field[n+1][m+2]+field[n][m], max);
        }
    }
    static void S(int n, int m){
        if(n+2<N&&m+1<M) {
            max = Math.max(field[n][m]+field[n+1][m]+field[n+1][m+1]+field[n+2][m+1], max);
            max = Math.max(field[n][m+1]+field[n+1][m+1]+field[n+1][m]+field[n+2][m], max);
        }
        if(n+1<N&&m+2<M) {
            max = Math.max(field[n][m]+field[n][m+1]+field[n+1][m+1]+field[n+1][m+2], max);
            max = Math.max(field[n+1][m]+field[n+1][m+1]+field[n][m+1]+field[n][m+2], max);
        }
    }
    static void T(int n, int m){
        if(n+2<N&&m+1<M) {
            max = Math.max(field[n][m]+field[n+1][m]+field[n+2][m]+field[n+1][m+1], max);
            max = Math.max(field[n][m+1]+field[n+1][m+1]+field[n+2][m+1]+field[n+1][m], max);
        }
        if(n+1<N&&m+2<M) {
            max = Math.max(field[n+1][m]+field[n+1][m+1]+field[n+1][m+2]+field[n][m+1], max);
            max = Math.max(field[n][m]+field[n][m+1]+field[n][m+2]+field[n+1][m+1], max);
        }
    }
}
