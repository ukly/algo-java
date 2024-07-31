package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class quiz1259 {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if(n == 0) break;
            if(n < 10){
                System.out.println("yes");
                continue;
            }
            String strN = "" + n;
            for(int i = 0; i < strN.length()/2; i++){
                if(strN.charAt(i) != strN.charAt(strN.length() - i - 1)){
                    System.out.println("no");
                    break;
                }
                if(i == (strN.length()/2 - 1)) System.out.println("yes");
            }
        }
    }
}
