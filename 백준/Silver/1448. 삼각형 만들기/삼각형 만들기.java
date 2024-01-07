import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        for(int i=list.size()-1; i>1; i--){
            if(list.get(i)<list.get(i-1)+list.get(i-2)){
                System.out.print(list.get(i)+list.get(i-1)+list.get(i-2));
                return;
            }
        }
        System.out.print(-1);
    }
}
