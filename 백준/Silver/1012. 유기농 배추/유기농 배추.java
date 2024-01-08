import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        int T = Integer.parseInt(br.readLine());
        while(0<T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt=0;
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int [][] field = new int[M+2][N+2];
            while(0<K){
                st = new StringTokenizer(br.readLine());
                field[Integer.parseInt(st.nextToken())+1][Integer.parseInt(st.nextToken())+1] = 1;
                K--;
            }
            for(int i=1; i<=M; i++){
                for(int j=1; j<=N; j++){
                    if(field[i][j]==1){
                        int m=i;
                        int n=j;
                        while(true){
                            field[m][n]=0;
                            if(field[m][n+1]==1){
                                s.push(n+1);
                                s.push(m);
                            }
                            if(field[m-1][n]==1){
                                s.push(n);
                                s.push(m-1);
                            }
                            if(field[m][n-1]==1){
                                s.push(n-1);
                                s.push(m);
                            }
                            if(field[m+1][n]==1){
                                s.push(n);
                                s.push(m+1);
                            }
                            if(s.empty()) break;
                            m= s.pop();
                            n= s.pop();
                        }
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
            T--;
        }
        System.out.println(sb);
    }
}
