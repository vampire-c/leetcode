package leetcode.problems;

class Solution0171 {

    static void main(String[] args) {
        new Solution0171().titleToNumber("ZY");
        // 26*26^1 + 25*26^0
    }


    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int m = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int temp = columnTitle.charAt(i) - 'A' + 1;
            ans += temp * m;
            m *= 26;
        }
        return ans;
    }

    public int titleToNumber1(String columnTitle) {
        int l = columnTitle.length();
        int ans = 0;
        for (int i = 0; i < l; i++) {
            char c = columnTitle.charAt(l - 1 - i);
            ans += (int) ((c - 'A' + 1) * Math.pow(26, i));
            // char c = columnTitle.charAt(i);
            // ans = ans * 26 + (c - 'A' + 1);
        }
        return ans;
    }
}
