import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        boolean swap = true;
        int max = N-1;
        while(swap||max<=1){
            swap = false;
            for(int i=0; i<max; i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1]=temp;
                    swap = true;
                }
            }
            max--;
        }
        for(int a : arr){
            sb.append(a).append("\n");
        }
        System.out.print(sb);
    }
}
