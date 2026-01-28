package leetcode.problems;

class Solution1446 {

    static void main(String[] args) {
        // new Solution1446().maxPower("abbcccddddeeeeedcba");
        new Solution1446().maxPower("leetcode");
    }

    public int maxPower(String s) {
        char[] ca = s.toCharArray();
        int ans = 1;
        int count = 1;
        for (int i = 1; i < ca.length; i++) {
            if (ca[i] == ca[i - 1]) {
                count++;
                ans = Math.max(ans, count);
            } else {
                count = 1;
            }
        }
        return ans;
    }
}
