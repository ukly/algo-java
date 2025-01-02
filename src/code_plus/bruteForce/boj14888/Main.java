package code_plus.bruteForce.boj14888;

import java.io.*;
import java.util.*;

public class Main {
    private static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    private static int[] nums;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        int[] operations = new int[n-1];

        for (int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for (int i=0; i<4; i++){
            int n = Integer.parseInt(st.nextToken());
            for(int j=0; j<n; j++){
                operations[idx] = i;
                idx++;
            }
        }

        permuteUnique(operations);

        System.out.println(max);
        System.out.println(min);

    }

    public static void permuteUnique(int[] nums) {
        Arrays.sort(nums); // 정렬하여 중복 처리
        boolean[] used = new boolean[nums.length];
        backtrack(new ArrayList<>(), nums, used);
    }

    private static void backtrack(List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            int result = calc(tempList);
            if(result > max) max = result;
            if(result < min) min = result;
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 중복 방지 조건
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private static int calc(List<Integer> calcs){
        int result = nums[0];
        for(int i=1; i<n; i++){
            if(calcs.get(i-1) == 0){
                result += nums[i];
            } else if(calcs.get(i-1) == 1){
                result -= nums[i];
            } else if(calcs.get(i-1) == 2){
                result *= nums[i];
            } else {
                result /= nums[i];
            }
        }

        return result;
    }
}