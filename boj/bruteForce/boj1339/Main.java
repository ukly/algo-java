package boj.bruteForce.boj1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class Main {
    private static int n, answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        List<String> words = new ArrayList<>();
        int[] alphabets = new int[26];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words.add(word);
        }

        for(String word : words){
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(word.length() - i - 1);
                alphabets[c-65] += (int)Math.pow(10, i);
            }
        }
        Arrays.sort(alphabets);
        for(int i=9; i>-1; i--){
            answer += alphabets[16+i] * i;
        }

        System.out.println(answer);
    }
}
