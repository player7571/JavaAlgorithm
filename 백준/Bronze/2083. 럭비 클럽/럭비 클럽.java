import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals("# 0 0")) break;
            StringTokenizer st = new StringTokenizer(str);
            sb.append(st.nextToken()).append(" ");
            if(Integer.parseInt(st.nextToken())>17||Integer.parseInt(st.nextToken())>=80) sb.append("Senior\n");
            else sb.append("Junior\n");
        }
        System.out.print(sb);
    }
}
