package StringMatching;

import java.io.*;
import java.util.Arrays;

public class quiz1786 {
    private static char a[], p[];
    private static String answer="";
    private static int count=0, lps[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        a = br.readLine().toCharArray();
        p = br.readLine().toCharArray();

        lps = new int[p.length];

        int[] pi = compute_pi(p);

        int n = a.length;
        int m = p.length;
        int i = 0;
        int j = 0;
        while(i < n){
            if(a[i] == p[j]){
                i += 1;
                j += 1;
                if(j == m){
                    count++;
                    answer += i-j+1 + " ";
                    j = lps[j-1];
                }
            } else if (j==0){
                i++;
            } else {
                j = pi[j];
            }
        }
        bw.write(count+"\n"+answer);
        bw.flush();
        bw.close();
    }

    private static int[] compute_pi(char[] p){
        int m = p.length;
        int[] pi = new int[m];
        Arrays.fill(pi, 0);
        lps[0] = 0;
        int i = 1;
        int j = 0;

        while(i < m-1){
            if(p[i] == p[j]){
                lps[i] = j+1;
                i += 1;
                j += 1;
                pi[i] = j;
            } else if (j == 0) {
                lps[i] = j;
                i += 1;
                pi[i] = j;
            } else {
                j = pi[j];
            }
        }
        if(i < m){
            if(p[i] == p[j]){
                lps[i] = j+1;
            } else {
                lps[i] = 0;
            }
        }

        return pi;
    }
}
