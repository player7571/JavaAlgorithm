import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N= Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int avg=0;
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(br.readLine());
            list.add(a);
            avg+=a;
        }
        Collections.sort(list);
        if(avg>0){
            if(((double)avg/(double)N-avg/N)>=0.5) avg=avg/N+1;
            else avg/=N;
        }
        else{
            if(((double)avg/(double)N-avg/N)>=-0.5) avg=avg/N;
            else avg=avg/N-1;
        }
        int now=list.get(0);
        int cnt=0, i=0;
        ArrayList<Integer> mode = new ArrayList<>();
        list.add(list.get(list.size()-1)+1);
        for(int li : list){
            if(now!=li){
                if(i>=cnt){
                    if(i!=cnt){
                        mode.clear();
                    }
                    cnt = i;
                    mode.add(now);
                }
                i=0;
                now=li;
            }
            i++;
        }
        list.remove(list.size()-1);
        sb.append(avg).append("\n");
        sb.append(list.get(list.size()/2)).append("\n");
        if(mode.size()==1) sb.append(mode.get(0)).append("\n");
        else {
            Collections.sort(mode);
            sb.append(mode.get(1)).append("\n");
        }
        sb.append(list.get(list.size()-1)-list.get(0));
        System.out.println(sb);
    }
}
