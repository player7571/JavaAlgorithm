import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        while(N-->0){
            String str = br.readLine();
            switch (str){
                case "pop":
                    if(queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front":
                    if(queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.peekFirst()).append("\n");
                    break;
                case "back":
                    if(queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.peekLast()).append("\n");
                    break;
                default:
                    StringTokenizer st = new StringTokenizer(str);
                    st.nextToken();
                    queue.add(Integer.parseInt(st.nextToken()));
            }
        }
        System.out.print(sb);
    }
}
