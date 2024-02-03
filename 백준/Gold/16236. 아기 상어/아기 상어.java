import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //상어가 지금 있는 위치, 이동한 거리를 저장하는 배열 하나 만들기 ++상어의 현재 크기랑 현재 크기일때 먹은 물고기의 수도 저장해야 할듯? 이걸로 먹는 물고기에 따라 크기 키워주기
    //bfs써서 갈수있는곳으로 계속 가다가 물고기를 먹게되면 상어 위치를 거기로 바꾸고 원래 상어의 위치와 물고기를 먹은 위치의 거리만큼 이동한 거리에 더함
    //글고 물고기 먹고 큐랑 visited 초기화 해야할듯?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> queue = new LinkedList<>();//큐에 들어가는 배열 0x값 1y값 2거리
        int[] shark = new int[5];//상어 x위치, 상어 y위치, 상어가 이동한 거리(시간), 상어의 현재 크기, 상어가 현재 크기일때 먹은 물고기의 수
        int[] dy = {0, -1, 1, 0};
        int[] dx = {-1, 0, 0, 1};
        int N = Integer.parseInt(br.readLine());
        int[][] field = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
                if(field[i][j]==9){
                    queue.add(new int[]{i, j, 0});
                    shark[0] = i;
                    shark[1] = j;
                    shark[3] = 2;
                    field[i][j]=0;
                    visited[i][j]=true;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(field[now[0]][now[1]]!=0&&field[now[0]][now[1]]<shark[3]){
                while(!queue.isEmpty()){
                    int[] cmp = queue.poll();
                    if(now[2]==cmp[2]&&field[cmp[0]][cmp[1]]<shark[3]&&field[cmp[0]][cmp[1]]!=0){
                        if(now[0]>cmp[0]){
                            now[0] = cmp[0];
                            now[1] = cmp[1];
                        }
                        else if(now[0]==cmp[0]){
                            if(now[1]>cmp[1]){
                                now[1] = cmp[1];
                            }
                        }
                    }
                }
                //같은 줄의 오른쪽 2칸옆과 왼쪽밑에 먹을수 있는 물고기가 있을때 왼쪽 아래로 가는 문제가 있음 어케해결하지(해결)
                //위에건 해결했는데 상어보다 큰 물고기가 있어서 피해가야할때 거리를 그만큼 더해줘야되는데 최단거리로 가서 문제발생.. 이건 큐에넣는 배열에 거리도 추가해주면 될듯?(해결)
                field[now[0]][now[1]]=0;
                shark[4]++;
                if(shark[3]==shark[4]){
                    shark[4]=0;
                    shark[3]++;
                }
                shark[2] += now[2];
                shark[0] = now[0];
                shark[1] = now[1];
                now[2] = 0;
                visited = new boolean[N][N];
                visited[now[0]][now[1]]=true;
//                System.out.println((now[0]+1)+" "+(now[1]+1)+" "+shark[2]+" "+shark[3]);
            }
            for(int i=0; i<4; i++){
                int x = now[0]+dx[i];
                int y = now[1]+dy[i];
                if(x>=0&&x<N&&y>=0&&y<N){
                    if(field[x][y]<=shark[3]&&!visited[x][y]){
                        queue.add(new int[]{x, y, now[2]+1});
                        visited[x][y]=true;
                    }
                }
            }
        }
        System.out.print(shark[2]);
    }
}
