import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> arr = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] A = new int[N];

        for(int i=N-1; i>=0; i--){
            A[i] = Integer.parseInt(st.nextToken());
        }
        arr.add(1);
        for(int i=1; i<N; i++){
            if(A[i]==1){
                arr.addFirst(i+1);
            }
            else if(A[i]==2){
                int num= arr.remove();
                arr.addFirst(i+1);
                arr.addFirst(num);
            }
            else{
                arr.add(i+1);
            }
        }
        for(Integer li : arr){
            sb.append(li).append(" ");
        }
        System.out.print(sb);
    }
}
