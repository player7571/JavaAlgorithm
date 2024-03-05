import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] bool = new boolean[10001];
        for(int i=1; i<10000; i++){
            int num = i+ i/1000+ i/100-i/1000*10 + i/10-i/100*10 + i%10;
            if(num>10000) continue;
            bool[num] = true;
        }
        for(int i=1; i<=10000; i++){
            if(!bool[i])sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}
