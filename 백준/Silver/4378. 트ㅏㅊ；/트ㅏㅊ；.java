import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String word = br.readLine();
            if (word==null || word.isEmpty()) return;
            char [] beforeWord = word.toCharArray();
            char [] keyboard = {'`', '1','2','3','4','5','6','7','8','9','0','-','=','Q','W','E','R','T','Y','U','I','O','P','[',']','\\','A','S','D','F','G','H','J','K','L',';','\'','Z','X','C','V','B','N','M',',','.','/',' '};
            char [] afterWord = new char [beforeWord.length];
            for(int i=0; i<beforeWord.length; i++){
                int j = 0;
                if(beforeWord[i] != ' '){
                    while(keyboard[j]!=beforeWord[i]) j++;
                    afterWord[i] = keyboard[j-1];
                }
                else {
                    afterWord[i] = keyboard[keyboard.length-1];
                }
            }
            for(int i=0; i<afterWord.length; i++){
                System.out.print(afterWord[i]);
            }
            System.out.println();
        }
    }
}