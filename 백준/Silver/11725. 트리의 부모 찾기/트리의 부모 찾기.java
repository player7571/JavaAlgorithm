import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Node {
        int val;
        int parent = 0;
        ArrayList<Integer> child = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] tree = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new Node(i);
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree[node1].child.add(node2);
            tree[node2].child.add(node1);
        }

        boolean[] visited = new boolean[N + 1];
        dfs(tree, 1, visited);

        for (int i = 2; i <= N; i++) {
            sb.append(tree[i].parent).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(Node[] tree, int node, boolean[] visited) {
        visited[node] = true;

        for (int child : tree[node].child) {
            if (!visited[child]) {
                tree[child].parent = node;
                dfs(tree, child, visited);
            }
        }
    }
}
