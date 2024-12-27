package week3;

import java.io.*;

public class quiz10989 {
    private static int n, a;
    private static int[] arr = new int[100001];;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        //입력 받으면서 해당 인덱스 count값 증가
        for(int i=0; i<n; i++){
            a = Integer.parseInt(br.readLine());
            arr[a] += 1;
        }

        //순회하면서 Count있으면 출력
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                for(int j=0; j<arr[i]; j++) bw.write(i + "\n");
            }
        }

        bw.flush();

    }
}
