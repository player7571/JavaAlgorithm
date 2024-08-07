import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2024-08-07
public class Main {

    static char[][] U;
    static char[][] D;
    static char[][] F;
    static char[][] B;
    static char[][] L;
    static char[][] R;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Cubing cubing = new Cubing();

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            U = new char[][]{{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'}};
            D = new char[][]{{'y', 'y', 'y'}, {'y', 'y', 'y'}, {'y', 'y', 'y'}};
            F = new char[][]{{'r', 'r', 'r'}, {'r', 'r', 'r'}, {'r', 'r', 'r'}};
            B = new char[][]{{'o', 'o', 'o'}, {'o', 'o', 'o'}, {'o', 'o', 'o'}};
            L = new char[][]{{'g', 'g', 'g'}, {'g', 'g', 'g'}, {'g', 'g', 'g'}};
            R = new char[][]{{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}};
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                String now = st.nextToken();
                boolean dir = now.charAt(1) == '+';
                switch (now.charAt(0)){
                    case 'L':
                        cubing.left(dir);
                        cubing.rotation(dir, L);
                        break;
                    case 'R':
                        cubing.right(dir);
                        cubing.rotation(dir, R);
                        break;
                    case 'U':
                        cubing.up(dir);
                        cubing.rotation(dir, U);
                        break;
                    case 'D':
                        cubing.down(dir);
                        cubing.rotation(dir, D);
                        break;
                    case 'F':
                        cubing.front(dir);
                        cubing.rotation(dir, F);
                        break;
                    case 'B':
                        cubing.back(dir);
                        cubing.rotation(dir, B);
                        break;
                    default:
                }
//                cubing.print();
            }
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    sb.append(U[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    public static class Cubing{
        void up(boolean dir) {
            if (dir) {
                char[] temp = F[0].clone();
                F[0] = R[0];
                R[0] = B[0];
                B[0] = L[0];
                L[0] = temp;
            } else {
                char[] temp = F[0].clone();
                F[0] = L[0];
                L[0] = B[0];
                B[0] = R[0];
                R[0] = temp;
            }
        }

        void down(boolean dir) {
            if (!dir) {
                char[] temp = F[2].clone();
                F[2] = R[2];
                R[2] = B[2];
                B[2] = L[2];
                L[2] = temp;
            } else {
                char[] temp = F[2].clone();
                F[2] = L[2];
                L[2] = B[2];
                B[2] = R[2];
                R[2] = temp;
            }
        }

        void front(boolean dir) {
            char[] temp = U[2].clone();
            if (dir) {
                U[2] = new char[]{L[2][2], L[1][2], L[0][2]};
                for (int i = 0; i < 3; i++) L[i][2] = D[0][i];
                D[0] = new char[]{R[2][0], R[1][0], R[0][0]};
                for (int i = 0; i < 3; i++) R[i][0] = temp[i];
            } else {
                U[2] = new char[]{R[0][0], R[1][0], R[2][0]};
                for (int i = 0; i < 3; i++) R[2-i][0] = D[0][i];
                D[0] = new char[]{L[0][2], L[1][2], L[2][2]};
                for (int i = 0; i < 3; i++) L[2 - i][2] = temp[i];
            }
        }

        void back(boolean dir) {
            char[] temp = U[0].clone();
            if (!dir) {
                U[0] = new char[]{L[2][0], L[1][0], L[0][0]};
                for (int i = 0; i < 3; i++) L[i][0] = D[2][i];
                D[2] = new char[]{R[2][2], R[1][2], R[0][2]};
                for (int i = 0; i < 3; i++) R[i][2] = temp[i];
            } else {
                U[0] = new char[]{R[0][2], R[1][2], R[2][2]};
                for (int i = 0; i < 3; i++) R[i][2] = D[2][2 - i];
                D[2] = new char[]{L[0][0], L[1][0], L[2][0]};
                for (int i = 0; i < 3; i++) L[2 - i][0] = temp[i];
            }
        }

        void left(boolean dir) {
            char[] u = new char[]{U[0][0], U[1][0], U[2][0]};
            char[] f = new char[]{F[0][0], F[1][0], F[2][0]};
            char[] d = new char[]{D[0][0], D[1][0], D[2][0]};
            char[] b = new char[]{B[2][2], B[1][2], B[0][2]};
            if (!dir) {
                U[0][0] = f[0];
                U[1][0] = f[1];
                U[2][0] = f[2];
                F[0][0] = d[0];
                F[1][0] = d[1];
                F[2][0] = d[2];
                D[0][0] = b[0];
                D[1][0] = b[1];
                D[2][0] = b[2];
                B[2][2] = u[0];
                B[1][2] = u[1];
                B[0][2] = u[2];
            } else {
                U[0][0] = b[0];
                U[1][0] = b[1];
                U[2][0] = b[2];
                F[0][0] = u[0];
                F[1][0] = u[1];
                F[2][0] = u[2];
                D[0][0] = f[0];
                D[1][0] = f[1];
                D[2][0] = f[2];
                B[2][2] = d[0];
                B[1][2] = d[1];
                B[0][2] = d[2];
            }
        }

        void right(boolean dir) {
            char[] u = new char[]{U[0][2], U[1][2], U[2][2]};
            char[] f = new char[]{F[0][2], F[1][2], F[2][2]};
            char[] d = new char[]{D[0][2], D[1][2], D[2][2]};
            char[] b = new char[]{B[2][0], B[1][0], B[0][0]};
            if (dir) {
                U[0][2] = f[0];
                U[1][2] = f[1];
                U[2][2] = f[2];
                F[0][2] = d[0];
                F[1][2] = d[1];
                F[2][2] = d[2];
                D[0][2] = b[0];
                D[1][2] = b[1];
                D[2][2] = b[2];
                B[2][0] = u[0];
                B[1][0] = u[1];
                B[0][0] = u[2];
            } else {
                U[0][2] = b[0];
                U[1][2] = b[1];
                U[2][2] = b[2];
                F[0][2] = u[0];
                F[1][2] = u[1];
                F[2][2] = u[2];
                D[0][2] = f[0];
                D[1][2] = f[1];
                D[2][2] = f[2];
                B[2][0] = d[0];
                B[1][0] = d[1];
                B[0][0] = d[2];
            }
        }

        void rotation(boolean right, char[][] target) {
            if (right) {
                // 시계 방향으로 회전
                char temp = target[0][0];
                target[0][0] = target[2][0];
                target[2][0] = target[2][2];
                target[2][2] = target[0][2];
                target[0][2] = temp;

                temp = target[0][1];
                target[0][1] = target[1][0];
                target[1][0] = target[2][1];
                target[2][1] = target[1][2];
                target[1][2] = temp;
            } else {
                // 반시계 방향으로 회전
                char temp = target[0][0];
                target[0][0] = target[0][2];
                target[0][2] = target[2][2];
                target[2][2] = target[2][0];
                target[2][0] = temp;

                temp = target[0][1];
                target[0][1] = target[1][2];
                target[1][2] = target[2][1];
                target[2][1] = target[1][0];
                target[1][0] = temp;
            }
        }




//        void print(){
//            for(int i=0; i<3; i++){
//                for(int j=0; j<3; j++){
//                    sb.append(U[i][j]);
//                }
//                sb.append("\n");
//            }
//            for(int i=0; i<3; i++){
//                for(int j=0; j<3; j++){
//                    sb.append(F[i][j]);
//                }
//                sb.append("\n");
//            }
//            for(int i=0; i<3; i++){
//                for(int j=0; j<3; j++){
//                    sb.append(R[i][j]);
//                }
//                sb.append("\n");
//            }
//            for(int i=0; i<3; i++){
//                for(int j=0; j<3; j++){
//                    sb.append(B[i][j]);
//                }
//                sb.append("\n");
//            }
//            for(int i=0; i<3; i++){
//                for(int j=0; j<3; j++){
//                    sb.append(L[i][j]);
//                }
//                sb.append("\n");
//            }
//            for(int i=0; i<3; i++){
//                for(int j=0; j<3; j++){
//                    sb.append(D[i][j]);
//                }
//                sb.append("\n");
//            }
//            sb.append("\n" +
//                    "-----------------------" +
//                    "\n");
//        }
    }
}
