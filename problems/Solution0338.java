package leetcode.problems;

/*
给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
返回一个长度为 n + 1 的数组 ans 作为答案。
 */
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
