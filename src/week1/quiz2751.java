package week1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class quiz2751 {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i<N; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        for(int num: arr){
            bw.write(num+"\n");
        }

        bw.flush();
        bw.close();
    }
}
