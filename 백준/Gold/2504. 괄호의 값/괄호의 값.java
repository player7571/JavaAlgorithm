import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int mul = 1;
        boolean open = false;
        char now;
        String str = br.readLine();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);switch (ch){
                case'(':
                case'[':
                    stack.push(ch);
                    open = true;
                    if(stack.peek()=='(') mul*=2;
                    else mul*=3;
                    break;
                case')':
                    if(stack.isEmpty()){
                        System.out.print(0);
                        return;
                    }
                    now = stack.pop();
                    if(now=='[') {
                        System.out.print(0);
                        return;
                    }
                    if(mul>1) mul/=2;
                    if(open){
                        ans+=(mul*2);
                        open = false;
                    }
                    break;
                default:
                    if(stack.isEmpty()){
                        System.out.print(0);
                        return;
                    }
                    now = stack.pop();
                    if(now=='(') {
                        System.out.print(0);
                        return;
                    }
                    if(mul>1) mul/=3;
                    if(open){
                        ans+=(mul*3);
                        open = false;
                    }
            }
        }
        if(stack.isEmpty()) System.out.print(ans);
        else System.out.print(0);
    }
}
