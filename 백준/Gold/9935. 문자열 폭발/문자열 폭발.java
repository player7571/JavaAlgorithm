import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();
        char[] ch= br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        for(int i=0; i<ch.length; i++){
            deque.addLast(ch[i]);
            if(ch[i]==bomb[bomb.length-1]){
                for(int k=0; k<bomb.length; k++){
                    if(deque.isEmpty()) {
                        while(!stack.isEmpty()){
                            deque.addLast(stack.pop());
                        }
                        break;
                    }
                    if(deque.peekLast()==bomb[bomb.length-1-k]) stack.add(deque.removeLast());
                    else {
                        while(!stack.isEmpty()){
                            deque.addLast(stack.pop());
                        }
                    }
                }
                stack.clear();
            }
        }
        while(!deque.isEmpty()){
            sb.append(deque.poll());
        }
        if(sb.length()==0) System.out.print("FRULA");
        else System.out.print(sb);
    }
}
