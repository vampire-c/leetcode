package leetcode.math;

class Solution1Q2 {

    public static void main(String[] args) {
        new Solution1Q2().pivotInteger(8);
    }

    public int pivotInteger(int n) {
        if (n > 1) {
            for (int i = 1; i <= n; i++) {
                if ((1 + i) * i / 2 == (i + n) * (n + 1 - i) / 2) {
                    return i;
                }
            }
        } else if (n==1){
            return 1;
        }
        return -1;
    }
}
