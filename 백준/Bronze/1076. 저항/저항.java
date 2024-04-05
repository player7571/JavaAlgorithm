import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long ans = 0;
        switch (br.readLine()){
            case "black":
                break;
            case "brown":
                ans = 10;
                break;
            case "red":
                ans = 20;
                break;
            case "orange":
                ans = 30;
                break;
            case "yellow":
                ans = 40;
                break;
            case "green":
                ans = 50;
                break;
            case "blue":
                ans = 60;
                break;
            case "violet":
                ans = 70;
                break;
            case "grey":
                ans = 80;
                break;
            default:
                ans = 90;
                break;
        }
        switch (br.readLine()){
            case "black":
                break;
            case "brown":
                ans += 1;
                break;
            case "red":
                ans += 2;
                break;
            case "orange":
                ans += 3;
                break;
            case "yellow":
                ans += 4;
                break;
            case "green":
                ans += 5;
                break;
            case "blue":
                ans += 6;
                break;
            case "violet":
                ans += 7;
                break;
            case "grey":
                ans += 8;
                break;
            default:
                ans += 9;
                break;
        }
        switch (br.readLine()){
            case "black":
                ans*=1;
                break;
            case "brown":
                ans*=10;
                break;
            case "red":
                ans*=100;
                break;
            case "orange":
                ans*=1000;
                break;
            case "yellow":
                ans*=10000;
                break;
            case "green":
                ans*=100000;
                break;
            case "blue":
                ans*=1000000;
                break;
            case "violet":
                ans*=10000000;
                break;
            case "grey":
                ans*=100000000;
                break;
            default:
                ans*=1000000000;
                break;
        }
        System.out.print(ans);
    }
}
