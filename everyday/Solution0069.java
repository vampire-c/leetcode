package leetcode.everyday;

public class Solution0069 {

    public static void main(String[] args) {
        new Solution0069().mySqrt(8);
    }

    public int mySqrt(int x) {
        int intMax = (int) Math.sqrt(Integer.MAX_VALUE);
        int left = 0;
        int right = Math.min(x, intMax) + 1;
        while (left + 1 < right) {
            int m = (left + right) >>> 1;
            if (m * m <= x) {
                left = m;
            } else {
                right = m;
            }
        }
        return left;
    }
}
