import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean [] machi = new boolean[10];
    static int [] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        num = new int[10];
        for(int i=0; i<13; i++){
            num[Integer.parseInt(st.nextToken())]++;
        }
        int cnt=0;
        for(int i=1; i<10; i++){
            if(num[i]==2) cnt++;
            if(num[i]!=4)tenpai(i);
        }
        if(cnt==6) {
            for(int i=1; i<10; i++){
                if(num[i]==1) {
                    machi[i]=true;
                    break;
                }
            }
        }
        for(int i=1; i<10; i++){
            if(machi[i]) sb.append(i).append(" ");
        }
        if(sb.length()==0) System.out.print("-1");
        else System.out.print(sb);
    }
    static void tenpai(int s){
        for(int i=1; i<10; i++){
            if(find(s, i)){
                machi[s]=true;
                return;
            }
        }
    }
    static boolean find(int s, int i){
        int [] numF = new int[10];
        for(int k=1; k<10; k++){
            numF[k] = num[k];
        }
        numF[s]++;
        if(numF[i]<2) return false;
        else numF[i]-=2;
        for(int j=1; j<10; j++){
            if(numF[j]==0) continue;
            if(numF[j]>=3) numF[j]-=3;
            while(j<8&&numF[j]>0&&numF[j+1]>0&&numF[j+2]>0) {
                numF[j]--;
                numF[j+1]--;
                numF[j+2]--;
            }
        }
        boolean agaru = true;
        for(int j=1; j<10; j++){
            if(numF[j]!=0) {
                agaru=false;
                break;
            }
        }
        return agaru;
    }
}
