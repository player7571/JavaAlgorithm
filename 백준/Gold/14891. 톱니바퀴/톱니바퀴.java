import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] gear = new boolean[4][8];
    static int[] gearTop = new int[4];
    static boolean[] visited = new boolean[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<4; i++){
            String str = br.readLine();
            for(int j=0; j<8; j++){
                if(str.charAt(j)=='1') gear[i][j] = true;
            }
        }

        int K = Integer.parseInt(br.readLine());
        while (K-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken());
            for(int i=0; i<4; i++){
                visited[i] = false;
            }
            rotation(s, d);
        }
        int ans = 0;
        for(int i=0; i<4; i++){
            if(gear[i][gearTop[i]]){
                ans+= (int) Math.pow(2, i);
            }
        }
        System.out.print(ans);
    }

    static void rotation(int s, int d) {
        if (visited[s]) return;
        visited[s] = true;
        if (s == 0) {
            if (gear[s][(gearTop[s] + 2) % 8] != gear[s+1][(gearTop[s + 1] + 6) % 8]) {
                rotation(s + 1, -d);
            }
        } else if (s == 3) {
            if (gear[s][(gearTop[s] + 6) % 8] != gear[s-1][(gearTop[s - 1] + 2) % 8]) {
                rotation(s - 1, -d);
            }
        } else {
            if (gear[s][(gearTop[s] + 6) % 8] != gear[s-1][(gearTop[s - 1] + 2) % 8]) {
                rotation(s - 1, -d);}
            if (gear[s][(gearTop[s] + 2) % 8] != gear[s+1][(gearTop[s + 1] + 6) % 8]) {
                rotation(s + 1, -d);
            }
        }
        gearTop[s] = (gearTop[s]-d+8)%8;
    }
}
