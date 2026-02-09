package leetcode.problems;

class Solution0944 {

    public static void main(String[] args) {
        new Solution0944().minDeletionSize(new String[]{"cba", "daf", "ghi"});
    }

    public int minDeletionSize(String[] strs) {

        int l = strs.length;
        int m = strs[0].length();
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < l; j++) {
                if (strs[j - 1].charAt(i) > strs[j].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}
