package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class quiz1978 {
    private static int N, number, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        answer = N;

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            number = Integer.parseInt(st1.nextToken());

            if(number == 1) {
                answer -= 1;
                continue;
            }

            for(int j = 2; j < number; j++){
                if (number % j == 0) {
                    answer -= 1;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
