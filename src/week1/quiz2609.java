package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class quiz2609 {
    private static int A, B, divA, divB;
    private static int gcd, lcm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        gcd = gcd(A, B);
        divA = A / gcd;
        divB = B / gcd;
        lcm = divA * divB * gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
