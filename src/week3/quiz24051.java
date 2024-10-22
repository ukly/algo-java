package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quiz24051 {
    private static int n, k, arr[], idx, item, count = 0, answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        insertionSort(n);
        System.out.println(answer);
    }
    private static void insertionSort(int n){
        for (int i = 1; i < n; i++) {
            idx = i - 1;
            item = arr[i];

            while(idx >= 0 && item < arr[idx]){
                arr[idx+1] = arr[idx];
                count++;
                if(count == k) answer = arr[idx];
                idx--;
            }
            if(idx + 1 != i) {
                arr[idx+1] = item;
                count++;
                if(count == k) answer = item;
            }
        }
    }
}
