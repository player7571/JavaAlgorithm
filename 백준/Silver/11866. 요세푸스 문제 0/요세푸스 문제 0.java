import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            list.add(i);
        }
        int cnt = M-1;
        sb.append(list.remove(cnt));
        while(!list.isEmpty()){
            cnt+=M-1;
            if(cnt>=list.size()) cnt%=list.size();
            sb.append(", ").append(list.remove(cnt));
        }
        sb.append(">");
        System.out.print(sb);
    }
}
