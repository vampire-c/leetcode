package leetcode.problems;

class Solution0326 {

    static void main(String[] args) {
        new Solution0326().isPowerOfThree(27);
    }

    public boolean isPowerOfThree(int n) {
        return n > 0 && Math.pow(3, 19) % n == 0;
    }
}
