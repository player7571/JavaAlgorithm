import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] triangle = new ArrayList[n];
        ArrayList<Integer>[] sum = new ArrayList[n];
        for(int i=0; i<n; i++){
            triangle[i] = new ArrayList<>();
            sum[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                int num = Integer.parseInt(st.nextToken());
                triangle[i].add(num);
                sum[i].add(0);
            }
        }
        sum[0].set(0, triangle[0].get(0));
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});//높이, 가로, 크기
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0]+1<n){
                for(int i=now[1]; i<=now[1]+1; i++){
                    if(sum[now[0]+1].get(i)<sum[now[0]].get(now[1])+triangle[now[0]+1].get(i)) {
                        sum[now[0]+1].set(i, sum[now[0]].get(now[1])+triangle[now[0]+1].get(i));
                        queue.add(new int[]{now[0]+1, i});
                    }
                }
            }
        }
        Collections.sort(sum[n-1]);
        System.out.println(sum[n-1].get(sum[n-1].size()-1));
    }
}
