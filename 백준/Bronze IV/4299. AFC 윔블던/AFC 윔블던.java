import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int add = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());
        for(int i=0; i<=1000; i++){
            for(int j=i; j<=1000; j++){
                if(i+j==add){
                    if(j-i==sub){
                        System.out.print(j+" "+i);
                        return;
                    }
                    break;
                }
            }
        }
        System.out.print("-1");
    }
}
