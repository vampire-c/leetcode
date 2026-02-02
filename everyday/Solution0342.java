package leetcode.problems;

class Solution0342 {

    static void main(String[] args) {
        new Solution0342().isPowerOfFour(16);
    }

    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }

    public boolean isPowerOfFour1(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
