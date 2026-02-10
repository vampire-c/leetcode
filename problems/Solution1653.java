package leetcode.problems;

/*
给你一个字符串 s ，它仅包含字符 'a' 和 'b'。
你可以删除 s 中任意数目的字符，使得 s 平衡 。
当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡的(a都在b左边)。
请你返回使 s 平衡 的 最少 删除次数。
 */
class Solution1653 {

    static void main(String[] args) {
        new Solution1653().minimumDeletions("aabab");
    }

    public int minimumDeletions(String s) {
        int f = 0;
        int cntB = 0;
        for (char c : s.toCharArray()) {
            int x = c - 'a';
            cntB += x;
            int y = f + (x ^ 1);
            f = Math.min(y, cntB);
        }
        return f;
    }

    public int minimumDeletions3(String s) {
        int f = 0;
        int cntB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                cntB++;
            } else {
                f = Math.min(f + 1, cntB);
            }
        }
        return f;
    }

    public int minimumDeletions2(String s) {
        char[] ca = s.toCharArray();
        int ac = 0;
        for (char c : ca) {
            ac += 'b' - c;
        }
        int ans = ac;
        for (char c : ca) {
            if (c == 'a') {
                ac--;
            } else if (c == 'b') {
                ac++;
            }
            ans = Math.min(ans, ac);
        }
        return ans;
    }

    public int minimumDeletions1(String s) {
        char[] ca = s.toCharArray();
        int ac = 0;
        for (char c : ca) {
            ac += 'b' - c;
        }
        int ans = ac;
        for (char c : ca) {

            ac += (c - 'a') * 2 - 1;
            ans = Math.min(ans, ac);
        }
        return ans;
    }
}
