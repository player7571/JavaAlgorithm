import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] score = new int[4][4]; //후보, 점수
        while (N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<4; i++){
                score[i][Integer.parseInt(st.nextToken())]++;
            }
        }
        for(int i=3; i>0; i--){
            score[i][0] = score[i][1]+score[i][2]*2+score[i][3]*3;
        }
        int max = 0, e=0;
        boolean same = false;
        for(int i=1; i<4; i++){
            if(max<score[i][0]){
                e = i;
                max = score[i][0];
                same = false;
            }
            else if(max==score[i][0]){
                if(score[i][3]>score[e][3]){
                    e=i;
                    same = false;
                }
                else if(score[i][3]==score[e][3]){
                    if(score[i][2]>score[e][2]){
                        e=i;
                        same = false;
                    }
                    else if(score[i][2]==score[e][2]){
                        same = true;
                    }

                }
            }
        }
        if(same) System.out.print("0 "+max);
        else System.out.print(e+" "+max);
    }
}
