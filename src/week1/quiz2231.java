package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class quiz2231 {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i= N/2; i<N; i++){
            if (calcSum(i) == N) {
                System.out.println(i);
                break;
            }
            if(i == N-1) System.out.println(0);
        }
    }

    private static int calcSum(int n) {
        int sum = n;
        while(n != 0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}
