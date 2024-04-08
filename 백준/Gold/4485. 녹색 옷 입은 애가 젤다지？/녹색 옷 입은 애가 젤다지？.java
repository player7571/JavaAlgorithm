import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int x, y, val;

    public Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int cnt = 0;

        while (true) {
            cnt++;
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int[][] field = new int[N][N];
            boolean[][] visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    field[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, field[0][0]));

            while (!pq.isEmpty()) {
                Node now = pq.poll();

                if (now.x==N-1 && now.y==N-1) {
                    sb.append("Problem ").append(cnt).append(": ").append(now.val).append("\n");
                    break;
                }
                if (visited[now.x][now.y]) continue;
                visited[now.x][now.y] = true;
                for (int i = 0; i < 4; i++) {
                    int x = now.x + dx[i];
                    int y = now.y + dy[i];
                    if (x>=0 && y>=0 && x<N && y<N && !visited[x][y]) {
                        pq.offer(new Node(x, y, now.val + field[x][y]));
                    }
                }
            }
        }
        System.out.print(sb);
    }
}