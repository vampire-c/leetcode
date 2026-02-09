package leetcode.problems;

class Solution0231 {

    static void main(String[] args) {
        new Solution0231().isPowerOfTwo(1);
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
