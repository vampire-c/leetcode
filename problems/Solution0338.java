package leetcode.problems;

class Solution0338 {

    static void main(String[] args) {
        new Solution0338().countBits(5);
    }

    public int[] countBits(int n) {
        int[] ints = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ints[i] = Integer.bitCount(i);
        }
        return ints;
    }


}
