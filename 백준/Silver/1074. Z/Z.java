import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static int size;
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        size=(int)Math.pow(4, N);
        len=(int)Math.pow(2, N-1);
        search(N, size, len, len);
    }
    static void search(int N, int num, int x, int y){
        size/=4;
        len/=2;
        if(N==1){
            if(r%2==0&&c%2==0) System.out.print(num-4);
            else if(r%2==1&&c%2==1) System.out.print(num-1);
            else if(r%2==1) System.out.print(num-2);
            else System.out.print(num-3);
            return;
        }
        if(c>=x&&r>=y) search(N-1, num, x+len, y+len);
        else if (c<x&&r<y) search(N-1, num-3*size, x-len, y-len);
        else if (r<y) search(N-1, num-2*size, x+len, y-len);
        else search(N-1, num-size, x-len, y+len);
    }
}
