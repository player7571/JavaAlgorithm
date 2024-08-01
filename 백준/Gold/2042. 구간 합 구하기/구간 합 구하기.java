import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] num;
    static long[] tree;

    static class segmentTree{

        public long init(int start, int end, int node){
            if(start==end) return tree[node] = num[start];
            int mid = (start+end)/2;
            return tree[node] = init(start, mid, node*2)+init(mid+1, end, node*2+1);
        }

        public long sum(int start, int end, int node, int left, int right){
            if(left>end||right<start) return 0;
            if(left<=start && end<=right) return tree[node];
            int mid = (start+end)/2;
            return sum(start, mid, node*2, left, right)+sum(mid+1, end, node*2+1, left, right);
        }

        public void update(int start, int end, int node, int index, long dif){
            if(start>index || end<index) return;
            tree[node]+=dif;
            if(start==end) return;
            int mid = (start+end)/2;
            update(start, mid, node*2, index, dif);
            update(mid+1, end, node*2+1, index, dif);
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        num = new long[N+1];
        tree = new long[N*4];
        for(int i=1; i<=N; i++){
            num[i] = Long.parseLong(br.readLine());
        }
        segmentTree segmentTree = new segmentTree();
        segmentTree.init(1, N, 1);
        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a==1){
                segmentTree.update(1, N, 1, b, c-num[b]);
                num[b] = c;
            }
            else{
                sb.append(segmentTree.sum(1, N, 1, b, (int)c)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
