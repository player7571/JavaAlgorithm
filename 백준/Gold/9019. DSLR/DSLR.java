import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            Queue<String> ans = new LinkedList<>();
            sb.append(bfs(start)).append("\n");
        }
        System.out.print(sb);
    }
    static String bfs(int start){
        Queue<String> sQueue= new LinkedList<>();
        Queue<Integer> iQueue= new LinkedList<>();
        sQueue.add("D");
        sQueue.add("S");
        sQueue.add("L");
        sQueue.add("R");
        iQueue.add(start);
        iQueue.add(start);
        iQueue.add(start);
        iQueue.add(start);
        String [] visited = new String[10000];
        visited[start] = "";
        while(true){
            String str = sQueue.poll();
            int num = iQueue.poll();
            if(num==end) return visited[num];
            int now;
            if(str.equals("D")){
                now = D(num);
                if (visited[now] == null||visited[now].length() > visited[num].length()+1) visited[now] = visited[num] + "D";
                else continue;
            }
            else if(str.equals("S")){
                now = S(num);
                if (visited[now] == null||visited[now].length() > visited[num].length()+1) visited[now] = visited[num] + "S";
                else continue;
            }
            else if(str.equals("L")){
                now = L(num);
                if (visited[now] == null||visited[now].length() > visited[num].length()+1) visited[now] = visited[num] + "L";
                else continue;
            }
            else{
                now = R(num);
                if (visited[now] == null||visited[now].length() > visited[num].length()+1) visited[now] = visited[num] + "R";
                else continue;
            }
            iQueue.add(now);
            iQueue.add(now);
            iQueue.add(now);
            iQueue.add(now);
            sQueue.add("D");
            sQueue.add("S");
            sQueue.add("L");
            sQueue.add("R");
        }
    }
    static int D(int n){
        return n*2<10000 ? n*2 : n*2-10000;
    }
    static int S(int n){
        return n-1<0 ? 9999 : n-1;
    }
    static int L(int n){
        int[] num = new int[4];
        String str = String.valueOf(n);
        for(int i=4-str.length(); i<4; i++){
            num[i] = str.charAt(i-(4-str.length()))-'0';
        }
        return num[1]*1000+num[2]*100+num[3]*10+num[0];
    }
    static int R(int n){
        int[] num = new int[4];
        String str = String.valueOf(n);
        for(int i=4-str.length(); i<4; i++){
            num[i] = str.charAt(i-(4-str.length()))-'0';
        }
        return num[3]*1000+num[0]*100+num[1]*10+num[2];
    }
}
