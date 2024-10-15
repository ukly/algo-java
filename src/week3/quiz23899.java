package week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quiz23899 {
    private static int n, max_idx, answer=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        int[] arrA = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int[] arrB = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            if(Arrays.equals(arrA, arrB)){
                answer = 1;
                break;
            }
            max_idx = 0;
            for(int j=1; j<n-i; j++){
                if (arrA[max_idx] < arrA[j]) {
                    max_idx = j;
                }
            }
            if(arrA[max_idx] != arrA[n-1-i]) {
                swap(arrA, max_idx, n-1-i);
            }
            if(Arrays.equals(arrA, arrB)){
                answer = 1;
                break;
            }
        }
        bw.write(answer+"");
        bw.flush();
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}


