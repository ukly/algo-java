package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class quiz2292 {
    private static int N, answer, number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        N -= 1;
        answer = 1;
        number = 6;

        while(N >= number) {
            N -= number;
            answer += 1;
            number += 6;
        }
        if(N != 0) answer +=1;
        System.out.println(answer);
    }
}
