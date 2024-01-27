import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num, n, m;
        num = s.nextInt();
        long [] numberOfCase = new long[num];
        for(int i=0; i<num; i++){
            numberOfCase[i] = 1;
            n = s.nextInt();
            m = s.nextInt();
            if(m/2<n) n=m-n;
            for(int j=m; j>m-n; j--){
                numberOfCase[i] *= j;
            }
            for(int j=n; j>0; j--){
                numberOfCase[i] /= j;
            }
        }
        for(int i=0; i<num; i++){
            System.out.println(numberOfCase[i]);
        }
    }
}
