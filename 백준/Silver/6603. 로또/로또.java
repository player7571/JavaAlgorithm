import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String str = br.readLine();
            if(str.equals("0")) break;
            StringTokenizer st = new StringTokenizer(str);
            n = Integer.parseInt(st.nextToken());
            num = new int[n];
            for(int i=0;i <n; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<n; i++){
                ArrayList<Integer> ans = new ArrayList<>();
                boolean[] visited = new boolean[n];
                ans.add(num[i]);
                visited[i] = true;
                f(ans, visited);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static public void f(ArrayList<Integer> ans, boolean[] visited){
        if(ans.size()>6) return;
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            if(ans.isEmpty()||ans.get(ans.size()-1)<num[i]){
                visited[i] = true;
                ans.add(num[i]);
                f(ans, visited);
                visited[i] = false;
                ans.remove(ans.size()-1);
            }

        }
        if(ans.size()==6) {
            sb.append(ans.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")).append("\n");
        }
    }
}
