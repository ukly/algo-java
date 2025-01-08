package boj.greedy.boj1541;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");

        int answer = 0;

        for(int i=0; i<str.length; i++){
            int sum = 0;
            String[] plus = str[i].split("\\+");
            for(int j=0; j<plus.length; j++){
                sum += Integer.parseInt(plus[j]);
            }
            if(i==0) answer += sum;
            else     answer -= sum;
        }

        System.out.println(answer);
    }
}
