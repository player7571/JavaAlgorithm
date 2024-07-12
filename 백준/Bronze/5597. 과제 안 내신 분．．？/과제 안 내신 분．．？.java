import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] bool = new boolean[31];
        for(int i=1; i<=28; i++){
            bool[Integer.parseInt(br.readLine())] = true;
        }
        for(int i=1; i<=30; i++){
            if(!bool[i]) System.out.println(i);
        }
    }
}
