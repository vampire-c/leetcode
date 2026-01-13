package leetcode.math;

import java.util.Arrays;

public class Solution1Q1 {


    public static void main(String[] args) {
        new Solution1Q1().canMakeArithmeticProgression(new int[]{3, 5, 1});
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int x = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != x){
                return false;
            }
        }
        return true;
    }
}
