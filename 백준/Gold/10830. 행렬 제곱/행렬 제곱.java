import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[][] result;
    static boolean resultSet = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Long> stack = new Stack<>();
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long[][] matrix = new long[N][N];
        result = new long[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(B>0){
            for(long i=1; i<=B; i*=2){
                if(i*2>B) {
                    stack.add(i);
                    B-=i;
                }
            }
        }
        if(stack.peek()==1){
            stack.pop();
            for(int i=0; i<matrix.length; i++){
                System.arraycopy(matrix[i], 0, result[i], 0, matrix.length);
            }
            resultSet = true;
        }
        long k=2;
        while(!stack.isEmpty()){
            if(k==stack.peek()) {
//                System.out.println("---------------------------"+k);
                matrixSquare(matrix, true);
                stack.pop();
            }
            else matrixSquare(matrix, false);
            k*=2;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(result[i][j]%1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void matrixSquare(long[][] matrix, boolean tf){
        long[][] copy = new long[N][N];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                for(int k=0; k<matrix.length; k++){
                    copy[i][j] += ((matrix[i][k]*matrix[k][j])%1000);
                    copy[i][j]%=1000;
                }
            }
        }
        for(int i=0; i<matrix.length; i++){
            System.arraycopy(copy[i], 0, matrix[i], 0, matrix.length);
        }
        if(tf){
            if(!resultSet){
                for(int i=0; i<matrix.length; i++){
                    System.arraycopy(copy[i], 0, result[i], 0, matrix.length);
                }
                resultSet = true;
                return;
            }
            copy = new long[N][N];
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix.length; j++){
                    for(int k=0; k<matrix.length; k++){
                        copy[i][j] += ((result[i][k]*matrix[k][j])%1000);
                        copy[i][j]%=1000;
                    }
                }
            }
            for(int i=0; i<matrix.length; i++){
                System.arraycopy(copy[i], 0, result[i], 0, matrix.length);
            }
        }
//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
}
