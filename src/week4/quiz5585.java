package week4;

import java.io.*;

public class quiz5585 {
    private static int cost, res, coins = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cost = Integer.parseInt(br.readLine());
        res = 1000 - cost;
            coins += res / 500;
            res %= 500;

            coins += res / 100;
            res %= 100;

            coins += res / 50;
            res %= 50;

            coins += res / 10;
            res %= 10;

            coins += res / 5;
            res %= 5;

            coins += res / 1;
            res %= 1;

        System.out.println(coins);
    }
}
