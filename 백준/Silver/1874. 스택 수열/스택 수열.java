import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int [] num = new int [n];
        int cnt=0;
        for(int i=0; i<n; i++) num[i] = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            s.push(i+1);
            sb.append("+\n");
            if(s.get(s.size()-1)>=num[cnt]) {
                while (!s.empty() && s.get(s.size()-1)==num[cnt]) {
                    s.pop();
                    cnt++;
                    sb.append("-\n");
                }
            }
        }
        if(cnt==n) System.out.print(sb);
        else System.out.print("NO");
    }
}
