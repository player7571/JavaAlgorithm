import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        while (N-->0){
            list.add(br.readLine());
        }
        list.sort((o1, o2) -> {
            if(o1.length()!=o2.length()) return o1.length()-o2.length();
            int one = 0;
            int two = 0;
            for(int i=0; i<o1.length(); i++){
                if(o1.charAt(i)-'0'<10){
                    one+=o1.charAt(i)-'0';
                }
                if(o2.charAt(i)-'0'<10){
                    two+=o2.charAt(i)-'0';
                }
            }
            if(one!=two) return one-two;
            return o1.compareTo(o2);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}
