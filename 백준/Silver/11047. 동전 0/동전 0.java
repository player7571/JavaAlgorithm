import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        ArrayList<Integer> coin = new ArrayList<>();
        for(int i=0; i<N; i++) {
            int num= Integer.parseInt(br.readLine());
            if(num>K) continue;
            coin.add(num);
        }
        int min=0;
        int size = coin.size()-1;
        while(K!=0){
            if(K>=coin.get(size)) {
                K-=coin.get(size);
                min++;
            }
            else size--;
        }
        System.out.print(min);

    }
}
