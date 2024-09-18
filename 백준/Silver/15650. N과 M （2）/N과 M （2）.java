import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n , m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        solve(1, new ArrayList<>());
        System.out.print(sb);
    }

    static void solve(int num, ArrayList<Integer> arr){
        for(int i=num; i<=n; i++){
            arr.add(i);
            if(arr.size()==m) {
                sb.append(arr.toString()
                        .replace("[", "")
                        .replace("]", "")
                        .replace(",",""))
                        .append("\n");
            }
            solve(i+1, arr);
            arr.remove(arr.size()-1);
        }
    }
}
