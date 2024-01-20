import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] paper;
    static int white=0, blue=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new boolean[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                if(st.nextToken().equals("1")) paper[i][j] = true;
            }
        }
        cut(0, 0, N);
        System.out.print(white+"\n"+blue);
    }
    static void cut(int x, int y, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(paper[x][y]!=paper[x+i][y+j]) {
                    cut(x, y, n/2);
                    cut(x+n/2, y, n/2);
                    cut(x, y+n/2, n/2);
                    cut(x+n/2, y+n/2, n/2);
                    return;
                }
            }
        }
        if(paper[x][y]) blue++;
        else white++;
    }
}
