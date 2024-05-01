import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean bracket = false;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch=='<') {
                bracket=true;
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
            if(bracket){
                sb.append(str.charAt(i));
                if(ch=='>') bracket = false;
            }
            else {
                if(ch==' '){
                    while (!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                    continue;
                }
                stack.add(ch);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.print(sb);
    }
}
