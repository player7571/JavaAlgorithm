import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] field;
    static int r1, c1, r2, c2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken())+5000;
        c1 = Integer.parseInt(st.nextToken())+5000;
        r2 = Integer.parseInt(st.nextToken())+5000;
        c2 = Integer.parseInt(st.nextToken())+5000;
        field = new int[r2-r1+1][c2-c1+1];
        if(r1<=5000&&r2>=5000&&c1<=5000&&c2>=5000) field[5000-r1][5000-c1] = 1;
        right(5000, 5001, 2, 1);;
        int max = Math.max(Math.max(field[0][0], field[0][c2-c1]),  Math.max(field[r2-r1][0], field[r2-r1][c2-c1]));
        int len = String.valueOf(max).length();
        for(int i=0; i<=r2-r1; i++){
            for(int j=0; j<=c2-c1; j++){
                sb.append(String.format("%"+len+"d", field[i][j]));
                if(j!=c2-c1) sb.append(" ");
            }
            if(i!=r2-r1) sb.append("\n");
        }
        System.out.print(sb);
    }

    static void right(int x, int y, int now, int len){
        if(y+len>10002) return;//얘가 문제였네 ㅠㅠ
        for(int i=0; i<len; i++){
            if(x>=r1&&x<=r2&&y+i>=c1&&y+i<=c2){
                field[x-r1][y-c1+i] = now+i;
            }
        }
        up(x-1, y+len-1, now+len, len);
    }
    static void up(int x, int y, int now, int len){
        for(int i=0; i<len; i++){
            if(x-i>=r1&&x-i<=r2&&y>=c1&&y<=c2){
                field[x-r1-i][y-c1] = now+i;
            }
        }
        left(x-len+1, y-1, now+len, len+1);
    }
    static void left(int x, int y, int now, int len){
        for(int i=0; i<len; i++){
            if(x>=r1&&x<=r2&&y-i>=c1&&y-i<=c2){
                field[x-r1][y-c1-i] = now+i;
            }
        }
        down(x+1, y-len+1, now+len, len);
    }
    static void down(int x, int y, int now, int len){
        for(int i=0; i<len; i++){
            if(x+i>=r1&&x+i<=r2&&y>=c1&&y<=c2){
                field[x-r1+i][y-c1] = now+i;
            }
        }
        right(x+len-1, y+1, now+len, len+1);
    }
}