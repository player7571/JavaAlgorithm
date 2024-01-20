import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T>0){
            String str1 = br.readLine();
            char[] ch = str1.toCharArray();
            int num = Integer.parseInt(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            String str2 = br.readLine();
            if(num!=0){
                String[] strings = str2.substring(1, str2.length()-1).split(",");
                for(String s : strings){
                    arr.add(Integer.parseInt(s));
                }
            }
            boolean last = false;
            boolean brk = false;
            for(int i=0; i<ch.length; i++){
                if(ch[i]=='R') {
                    last=!last;
                }
                else if(arr.isEmpty()) {
                    sb.append("error\n");
                    brk = true;
                    break;
                }
                else if(last) arr.remove(arr.size()-1);
                else arr.remove(0);
            }
            if(arr.isEmpty()) {
                if(!brk) sb.append("[]\n");
                T--;
                continue;
            }
            if(last) Collections.reverse(arr);
            sb.append("[").append(arr.get(0));
            if(arr.size()>1){
                for(int i=1; i<arr.size(); i++){
                    sb.append(",").append(arr.get(i));
                }
            }
            sb.append("]\n");
            T--;
        }
        System.out.print(sb);
    }
}
