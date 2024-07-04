import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[10];
        boolean[][] P = new boolean[10][10];
        int[] A = new int[L];
        StringTokenizer st = new StringTokenizer(br.readLine());
        P[1][9] = P[9][1] = true;
        P[2][8] = P[8][2] = true;
        P[3][7] = P[7][3] = true;
        P[4][6] = P[6][4] = true;
        P[1][7] = P[7][1] = true;
        P[3][9] = P[9][3] = true;
        P[1][3] = P[3][1] = true;
        P[7][9] = P[9][7] = true;
        for(int i=0; i<L; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        visited[A[0]] = true;
        for(int i=1; i<L; i++){
            if(visited[A[i]]) {
                System.out.print("NO");
                return;
            }
            visited[A[i]] = true;
            if(P[A[i-1]][A[i]]){
                if(!visited[(A[i-1]+A[i])/2]) {
                    System.out.print("NO");
                    return;
                }
            }
        }
        System.out.print("YES");
    }
}
