import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.poll()).append("\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front":
                    if(deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.peek()).append("\n");
                    break;
                default:
                    if(deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.peekLast()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
