import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            if(str.length()==1&&str.charAt(0)=='.') break;
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                if(ch=='['||ch=='(') stack.push(ch);
                else if(ch==']'||ch==')'){
                    if(stack.isEmpty()) {
                        stack.push('0');
                        break;
                    }
                    if(ch==']'){
                        if(stack.peek()!='[') break;
                        stack.pop();
                    }
                    else {
                        if(stack.peek()!='(') break;
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty()) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.print(sb);
    }
}
