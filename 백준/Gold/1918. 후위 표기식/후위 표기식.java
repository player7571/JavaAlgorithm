import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] ch = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<ch.length; i++){
            switch (ch[i]){
                case'(':
                    stack.push('(');
                    break;
                case'*':
                case'/':
                    if(!stack.isEmpty()){
                        while(!stack.isEmpty()) {
                            if(stack.peek()=='('||stack.peek()=='+'||stack.peek()=='-') break;
                            sb.append(stack.pop());
                        }
                    }
                    stack.push(ch[i]);
                    break;
                case'+':
                case'-':
                    while(!stack.isEmpty()) {
                        if(stack.peek()=='(') break;
                        sb.append(stack.pop());
                    }
                    stack.push(ch[i]);
                    break;
                case')':
                    while(stack.peek()!='(') sb.append(stack.pop());
                    stack.pop();
                    break;
                default:
                    sb.append(ch[i]);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.print(sb);
    }
}
