package leetcode.problems;

class Solution0434 {

    static void main(String[] args) {
        new Solution0434().countSegments("Hello, my name is     John");
        // new Solution0434().countSegments(", , , ,        a, eaefa");
        // new Solution0434().countSegments("Of all the gin joints in all the towns in all the world,   ");
    }

    public int countSegments(String s) {
        int ans = 0;
        char[] ca = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || ca[i - 1] == ' ') && ca[i] != ' ') {
                ans++;
            }
        }
        return ans;
    }

    public int countSegments2(String s) {
        int l = s.length();
        int ans = 0;
        char[] ca = s.toCharArray();
        for (int i = 0; i < l; ) {
            if (ca[i] == ' ') {
                i++;
                continue;
            }
            while (i < l && ca[i] != ' ') {
                i++;
            }
            ans++;
        }
        return ans;
    }

    public int countSegments1(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        char[] ca = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < ca.length - 1; i++) {
            if (ca[i] == ' ' && (ca[i + 1] != ' ')) {
                ans++;
            }
        }
        return ++ans;
    }
}
