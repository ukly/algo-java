package boj.greedy.boj2138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static int[] arr1;
    public static int[] arr2;
    public static int[] target;
    public static int switchCnt1 = 0, switchCnt2 = 0;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr1 = new int[N];
        arr2 = new int[N];
        target = new int[N];

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        for(int i=0;i<N;i++) {
            arr1[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
            arr2[i] = arr1[i];
        }

        st = new StringTokenizer(br.readLine());
        s = st.nextToken();
        for(int i=0;i<N;i++) {
            target[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        //arr2의 0번쨰 스위치를 누르는 경우
        arr2[0] = arr2[0] == 1 ? 0 : 1;
        arr2[1] = arr2[1] == 1 ? 0 : 1;
        switchCnt2 += 1;

        //0번째는 검사안하고, 1번째부터 검사합니다. ( 0 번째는 arr2에서만 누르고 작동합니다. )
        for(int i=1;i<N;i++) {

            if(arr1[i-1] != target[i-1]) {
                if( i == N - 1 ) { //만약 마지막 전구를 검사한다면, 2개가 바뀌므로
                    arr1[i-1] = arr1[i-1] == 1 ? 0 : 1;
                    arr1[i] = arr1[i] == 1 ? 0 : 1;
                }
                else { // i번쨰 스위치 누를시 ( 좌, 현재위치, 우 )의 전구가 변합니다.
                    arr1[i-1] = arr1[i-1] == 1 ? 0 : 1;
                    arr1[i] = arr1[i] == 1 ? 0 : 1;
                    arr1[i+1] = arr1[i+1] == 1 ? 0 : 1;
                }
                switchCnt1 += 1;
            }

            if(arr2[i-1] != target[i-1]) { // i-1 번째가 target과 다르다면, i 번쨰에서 변경해주어야합니다.
                if( i == N - 1 ) { //만약 마지막 전구를 검사한다면, 2개가 바뀌므로
                    arr2[i-1] = arr2[i-1] == 1 ? 0 : 1;
                    arr2[i] = arr2[i] == 1 ? 0 : 1;
                }
                else { // i번쨰 스위치 누를시 ( 좌, 현재위치, 우 )의 전구가 변합니다.
                    arr2[i-1] = arr2[i-1] == 1 ? 0 : 1;
                    arr2[i] = arr2[i] == 1 ? 0 : 1;
                    arr2[i+1] = arr2[i+1] == 1 ? 0 : 1;
                }
                switchCnt2 += 1;
            }

        }

        for(int i=0;i<N;i++) {
            if(arr1[i] != target[i]) {
                switchCnt1 = Integer.MAX_VALUE;
            }
            if(arr2[i] != target[i]) {
                switchCnt2 = Integer.MAX_VALUE;
            }
        }

        int answer = Math.min(switchCnt1, switchCnt2);
        if(answer == Integer.MAX_VALUE) {
            System.out.println("-1");
        }else {
            System.out.println(answer);
        }


    }

}