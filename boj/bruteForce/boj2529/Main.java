package boj.bruteForce.boj2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;
    private static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = br.readLine();
        List<String> list = new ArrayList<>(Arrays.asList(input.split(" ")));

        Stack<Integer> maxStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        String answerMax = "";
        String answerMin = "";

        maxStack.add(9);
        minStack.add(0);

        for (int i = 1; i <= n; i++) {
            String equalSign = list.get(i-1);
            if(equalSign.equals(">")){
                //max 값 찾기
                while(!maxStack.isEmpty()){
                    int num = maxStack.pop();
                    answerMax += num;
                }
                maxStack.add(9-i);

                //min 값 찾기
                minStack.add(0+i);
            }
            else{
                //max 값 찾기
                maxStack.add(9-i);

                //min 값 찾기
                while(!minStack.isEmpty()){
                    int num = minStack.pop();
                    answerMin += num;
                }
                minStack.add(0+i);
            }
        }
        while(!maxStack.isEmpty()){
            int num = maxStack.pop();
            answerMax += num;
        }
        while(!minStack.isEmpty()){
            int num = minStack.pop();
            answerMin += num;
        }

        System.out.println(answerMax);
        System.out.println(answerMin);
    }
}
