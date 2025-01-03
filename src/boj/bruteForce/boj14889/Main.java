package boj.bruteForce.boj14889;

import java.util.*;
import java.io.*;

public class Main {
    private static int n, ability[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for(int i=0; i<n; i++) nums[i] = i+1;

        ability = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) ability[i][j] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> result = new ArrayList<>();

        //모든 팀 조합 생성
        combinations(nums, n/2, 0, new ArrayList<>(), result);

        int answer = Integer.MAX_VALUE;

        //팀 조합 내에서 시너지 계산
        for(List<Integer> combination : result){
            int newS = calcS(combination);
            if(newS < answer) answer = newS;
        }

        System.out.println(answer);
    }

    //조합 계산
    private static void combinations (int[] nums, int r, int start, List<Integer> combination, List<List<Integer>> result){
        if (combination.size() == r){
            Collections.sort(combination);
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i=start; i < n; i++){
            combination.add(nums[i]);
            combinations(nums, r, i+1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }

    private static int calcS (List<Integer> combination){
        List<Integer> other = new ArrayList<>();
        boolean[] check = new boolean[n];

        for(int num : combination){
            check[num-1] = true;
        }

        for(int i=0; i<n; i++){
            if(!check[i]) other.add(i+1);
        }

        int sum1 = 0;
        int sum2 = 0;

        for(int i=0; i<n/2 - 1; i++){
            for(int j=i+1; j<n/2; j++){
                int a = combination.get(i);
                int b = combination.get(j);

                int ab = ability[a][b];
                int ba = ability[b][a];

                sum1 += ab + ba;

                int otherA = other.get(i);
                int otherB = other.get(j);
                int otherAB = ability[otherA][otherB];
                int otherBA = ability[otherB][otherA];

                sum2 += otherAB + otherBA;
            }
        }

        if(sum1 > sum2) return sum1 - sum2;
        else            return sum2 - sum1;
    }
}
