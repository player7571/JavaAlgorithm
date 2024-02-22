import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String m = br.readLine();
        sb.append(n*(m.charAt(2)-'0')).append("\n").append(n*(m.charAt(1)-'0')).append("\n").append(n*(m.charAt(0)-'0')).append("\n").append(n*Integer.parseInt(m));
        System.out.print(sb);
    }
}
