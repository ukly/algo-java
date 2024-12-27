package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class quiz1517 {
    private static int n, k, temp, answer=0;
    private static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());


        System.out.println(bubbleSort(n));

    }

    private static String bubbleSort(int l){
        for(int i=l-1; i>=0; i--){
            for(int j=0; j<i; j++){
                if(arr[j] >  arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    answer++;
                }
                if(answer == k) return arr[j] + " " + arr[j+1];
            }
        }
        return "-1";
    }
}
