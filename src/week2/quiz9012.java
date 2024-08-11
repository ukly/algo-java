package week2;

import java.io.*;
import java.util.Stack;

public class quiz9012 {
    private static int t;
    private static String ps;
    private static int stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());

        while(t-- > 0 ) {
            ps = br.readLine();
            stack = 0;
            for(char ch : ps.toCharArray()){
                if (ch == ')'){
                    if(stack == 0){
                        stack++;
                        break;
                    }
                    else stack--;
                }
                else stack++;
            }
            if(stack != 0){
                bw.write("NO" + "\n");
            }
            else bw.write("YES" + "\n");
        }
        bw.flush();
    }
}
