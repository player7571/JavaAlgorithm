import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int cnt;
    static int[] queen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        if(N==1) {
            System.out.print("1");
            return;
        }
        if(N<=3) {
            System.out.print("0");
            return;
        }
        queen = new int[N+1];
        findNqueen(1);
        System.out.print(cnt);
    }
    static void findNqueen(int level) {
        if (level > N) {
            cnt++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (isSafe(level, i)) {
                queen[level] = i;
                findNqueen(level + 1);
            }
        }
    }

    static boolean isSafe(int row, int col) {
        for (int i = 1; i < row; i++) {
            if (queen[i] == col || Math.abs(i - row) == Math.abs(queen[i] - col)) {
                return false;
            }
        }
        return true;
    }
}
