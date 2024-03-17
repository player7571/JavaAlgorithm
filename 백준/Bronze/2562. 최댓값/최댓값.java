import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] max = new int[2];
        for(int i=1; i<=9; i++){
            int val = Integer.parseInt(br.readLine());
            if(max[1]<val){
                max[1] = val;
                max[0] = i;
            }
        }
        System.out.println(max[1]);
        System.out.print(max[0]);
    }
}
