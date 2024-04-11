import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        boolean odd = false;
        Map<Character, Integer> map = new HashMap<>();
        Stack<Character>stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }
        char middle = 0;
        for(int i=0; i<26; i++){
            char now = (char)('A'+i);
            int cnt = map.getOrDefault(now, 0);
            if(cnt>0){
                if(cnt%2==1){
                    if(odd) {
                        System.out.print("I'm Sorry Hansoo");
                        return;
                    }
                    middle = now;
                    odd = true;
                }
                for(int j=0; j<cnt/2; j++){
                    sb.append(now);
                    stack.add(now);
                }
            }
        }
        if(odd) sb.append(middle);
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.print(sb);
    }
}
