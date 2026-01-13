package leetcode.everyday;

import java.math.BigInteger;
import java.util.Arrays;

class Solution2575 {

    public static void main(String[] args) {
        new Solution2575().divisibilityArray("86217457695827338571", 3);
    }

    public int[] divisibilityArray(String word, int m) {
        int l = word.length();
        int[] ans = new int[l];
        long mod = 0;
        for (int i = 0; i < l; i++) {
            mod = (mod * 10 + (word.charAt(i) - '0')) % m;
            if (mod == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }
    public int[] divisibilityArray1(String word, int m) {
        int l = word.length();
        int[] ans = new int[l];
        Arrays.fill(ans, 0);
        for (int i = 1; i <= l; i++) {
            String substring = word.substring(0, i);
            BigInteger value = new BigInteger(substring);
            if (value.mod(BigInteger.valueOf(m)).equals(BigInteger.ZERO)) {
                ans[i - 1] = 1;
            }
        }
        return ans;
    }
}
