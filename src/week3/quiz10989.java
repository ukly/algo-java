package week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quiz10989 {
    private static int n, a;
    private static int[] arr = new int[100001];;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            a = Integer.parseInt(br.readLine());
            arr[a] += 1;
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                for(int j=0; j<arr[i]; j++) bw.write(i + "\n");
            }
        }

        bw.flush();

    }
}
