package week2;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class quiz1406 {
    private static String str;
    private static int n;
    private static String command;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = br.readLine();
        n = Integer.parseInt(br.readLine());

        char[] chars = str.toCharArray();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for(char ch : chars){
            leftStack.push(ch);
        }
        while(n-- > 0){
            command = br.readLine();
            if(command.length() != 1){
                StringTokenizer st = new StringTokenizer(command);
                if("P".equals(st.nextToken())) leftStack.push(st.nextToken().charAt(0));;
            } else {
                if (command.equals("L")) {
                    if (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                } else if (command.equals("D")) {
                    if (!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                } else {
                    if (!leftStack.isEmpty()) leftStack.pop();
                }
            }
        }
        for(char ch : leftStack) bw.write(ch);
        while (!rightStack.isEmpty()) bw.write(rightStack.pop()); ;
        bw.flush();
    }
}
