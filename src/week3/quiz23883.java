package week3;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class quiz23883 {
    private static int n, k, max_idx, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int mapSize = n;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        //key 값이 값, value 값이 인덱스
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            map.put(Integer.parseInt(st.nextToken()),i);
        }
        for(int i=0; i<n; i++){
            if(k==0) break;
            if(!map.get(n-1-i).equals(map.lastEntry().getValue())){
                a = map.get(n-1-i);
                b = map.lastEntry().getValue();
                System.out.println(a+ " " + b);
                map.put(n-1-i, b);
                map.put(mapSize-1, a);
                k--;
                mapSize--;
                map.remove(mapSize);
            }
        }
        if(k>0) bw.write(-1+"");
        else bw.write(a + " " + b);

        bw.flush();
    }
}


