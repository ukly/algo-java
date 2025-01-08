package boj.greedy.boj1744;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int answer = 0;
        boolean hasZero = false;

        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num > 0) positive.add(num);
            else if(num < 0) negative.add(num);
            else             hasZero = true;
        }

        positive.sort((a, b) -> b-a);
        negative.sort((a, b) -> a-b);
        Queue<Integer> positiveQueue = new LinkedList<>(positive);
        Queue<Integer> negativeQueue = new LinkedList<>(negative);

        while(positiveQueue.size() > 1){
            int a = positiveQueue.poll();
            int b = positiveQueue.poll();
            if(a*b > a+b) answer += a*b;
            else          answer += a+b;
        }
        if(!positiveQueue.isEmpty()) answer += positiveQueue.poll();

        while(negativeQueue.size() > 1){
            int a = negativeQueue.poll();
            int b = negativeQueue.poll();
            answer += a*b;
        }
        if(hasZero) negativeQueue.poll();
        if(!negativeQueue.isEmpty()) answer += negativeQueue.poll();

        System.out.println(answer);

    }
}