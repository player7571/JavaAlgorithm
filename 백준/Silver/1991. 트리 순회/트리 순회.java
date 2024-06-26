import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Node{

        char val;
        Node left, right;

        public Node(char val){
            this.val = val;
            left = null;
            right = null;
        }

    }

    static class Tree{

        Node root = null;

        void createNode(char data, char leftData, char rightData){
            if(root == null){
                root = new Node(data);
                if(leftData != '.'){
                    root.left = new Node(leftData);
                }
                if(rightData != '.'){
                    root.right = new Node(rightData);
                }
            }
            else{
                searchNode(root, data, leftData, rightData);
            }
        }

        void searchNode(Node node, char data, char leftData, char rightData){
            if(node==null) return;
            if(node.val == data){
                if(leftData != '.'){
                    node.left = new Node(leftData);
                }
                if(rightData != '.'){
                    node.right = new Node(rightData);
                }
            }
            else{
                searchNode(node.left, data, leftData, rightData);
                searchNode(node.right, data, leftData, rightData);
            }
        }

        void preOrder(Node node){
            if(node!=null){
                sb.append(node.val);
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        void inOrder(Node node){
            if(node!=null){
                inOrder(node.left);
                sb.append(node.val);
                inOrder(node.right);
            }
        }

        void postOrder(Node node){
            if(node!=null){
                postOrder(node.left);
                postOrder(node.right);
                sb.append(node.val);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        while (N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] ch = new char[3];
            ch[0] = st.nextToken().charAt(0);
            ch[1] = st.nextToken().charAt(0);
            ch[2] = st.nextToken().charAt(0);
            tree.createNode(ch[0], ch[1], ch[2]);
        }
        tree.preOrder(tree.root);
        sb.append("\n");
        tree.inOrder(tree.root);
        sb.append("\n");
        tree.postOrder(tree.root);
        System.out.print(sb);
    }
}
