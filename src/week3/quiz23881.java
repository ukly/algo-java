package week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quiz23881 {
    private static int n, k, max_idx, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            max_idx = 0;
            for(int j=1; j<n-i; j++){
                if (arr[max_idx] < arr[j]) {
                    max_idx = j;
                }
            }
            if(arr[max_idx] != arr[n-1-i]) {
                swap(arr, max_idx, n-1-i);
                a = arr[n-1-i];
                b = arr[max_idx];
                k--;
            }
            if(k==0) break;
        }
        if(k>0){
            bw.write(-1+"");
        } else {
            bw.write(b + " " + a);
        }
        bw.flush();
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}


