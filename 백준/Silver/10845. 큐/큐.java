import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
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
                    else sb.append(queue.peek()).append("\n");
                    break;
                default:
                    if(queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.peekLast()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
