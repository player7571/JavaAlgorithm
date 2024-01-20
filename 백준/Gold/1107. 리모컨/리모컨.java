import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] s = str.toCharArray();
        int[] n = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            n[i] = (int) s[i] - 48;
        }
        int N = Integer.parseInt(str);
        int M = Integer.parseInt(br.readLine());
        int hu = Math.abs(N - 100);
        if (M == 0) { //고장난 버튼이 없을때
            System.out.print(Math.min(n.length, hu));
            return;
        }
        boolean[] broken = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            broken[Integer.parseInt(st.nextToken())] = true;
        }
        if (M == 10) {//버튼이 전부 고장났을때
            System.out.print(hu);
            return;
        }
        int search =0;
        boolean brk;
        int min = 1000001;
        while(true){
            brk = false;
            str = String.valueOf(search);
            int [] ch = new int[str.length()];
            for(int i=0; i<ch.length; i++){
                ch[i]= str.charAt(i)-'0';
                if(broken[ch[i]]) {
                    brk = true;
                    break;
                }
            }
            if(ch.length>=n.length+1&&ch[0]>=2) break;
            if(brk) {
                search++;
                continue;
            }
            min = Math.min(Math.abs(search-N)+str.length(), min);
            search++;
        }
        System.out.print(Math.min(min, hu));
    }
}
