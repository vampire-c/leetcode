package leetcode.problems;

class Solution0292 {

    static void main(String[] args) {
        new Solution0292().canWinNim(4);
    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
