import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] keyboard = new String[3];
        keyboard[0] = "qwertyuiop";
        keyboard[1] = "asdfghjkl";
        keyboard[2] = "zxcvbnm";
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            String[] words = new String[n];
            for(int i=0; i<n; i++){
                words[i] = br.readLine();
            }
            int[][] loc = new int[word.length()][2];
            for(int l = 0; l<word.length(); l++){
                boolean found = false;
                for(int k = 0; k<3; k++){
                    for(int i=0; i<keyboard[k].length(); i++){
//                        System.out.println(word.charAt(l));
                        if(keyboard[k].charAt(i)==word.charAt(l)) {
                            loc[l][0] = i;
                            loc[l][1] = k;
                            found = true;
                            break;
                        }
                    }
                    if(found) break;
                }
            }

            Map<String, Integer> map = new HashMap<>();
            for(int j=0; j<n; j++){
                int ans = 0;
                for(int l=0; l<word.length(); l++){
                    boolean found = false;
                    for(int k = 0; k<3; k++){
                        for(int i=0; i<keyboard[k].length(); i++){
                            if(keyboard[k].charAt(i)==words[j].charAt(l)) {
//                                System.out.println(Math.abs(loc[l][0]-i));
//                                System.out.println(loc[l][0]+" "+i);
//                                System.out.println(Math.abs(loc[l][1]-k));
//                                System.out.println(loc[l][1]+" "+k);
                                ans += Math.abs(loc[l][0]-i);
                                ans += Math.abs(loc[l][1]-k);
                                found = true;
                                break;
                            }
                        }
                        if(found) break;
                    }
                }
                map.put(words[j], ans);
            }
            List<String> keySet = new ArrayList<>(map.keySet());
            Collections.sort(keySet);
            keySet.sort((o1, o2) -> map.get(o1).compareTo(map.get(o2)));
            for (String key : keySet) {
                sb.append(key).append(" ").append(map.get(key)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
