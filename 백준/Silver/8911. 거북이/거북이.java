import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] now;
    static int[] max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            String str = br.readLine();
            now = new int[3]; // x, y, 방향
            max = new int[4]; //북, 동, 남, 서
            for(int i=0; i<str.length(); i++){
                switch (str.charAt(i)){
                    case 'F':
                        move(true);
                        break;
                    case'B':
                        move(false);
                        break;
                    case'L':
                        now[2] = (now[2]+3)%4;
                        break;
                    default:
                        now[2] = (now[2]+1)%4;

                }
            }
            sb.append((max[0]-max[2])*(max[1]-max[3])).append("\n");
        }
        System.out.print(sb);
    }

    static void move(boolean val){
        int d;
        if(val) d = now[2];
        else d = (now[2]+2)%4;
        switch (d){
            case 0:
                now[1]++;
                max[0] = Math.max(max[0], now[1]);
                break;
            case 1:
                now[0]++;
                max[1] = Math.max(max[1], now[0]);
                break;
            case 2:
                now[1]--;
                max[2] = Math.min(max[2], now[1]);
                break;
            default:
                now[0]--;
                max[3] = Math.min(max[3], now[0]);
        }
    }
}
