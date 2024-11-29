package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quiz1931 {
    private static int n, answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        int[][] times = new int[n][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (a, b) -> {
            if (a[1] != b[1]) {
                // 두 번째 원소 기준 정렬
                return Integer.compare(a[1], b[1]);
            } else {
                // 두 번째 원소가 같으면 첫 번째 원소 기준 정렬
                return Integer.compare(a[0], b[0]);
            }
        });

        int[] min = times[0];

        for(int i=1; i<n; i++){
            if(min[1] <= times[i][0]){ //회의이 시작시간이 이전 회의의 끝보다 느린경우
                answer += 1;
                min = times[i];
            }
        }
        System.out.println(answer);
    }
}
