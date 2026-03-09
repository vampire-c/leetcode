package leetcode.problems;

/*
给你一个二进制字符串 s ，该字符串 不含前导零 。
如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。
 */
class Solution1784 {

    static void main(String[] args) {
        new Solution1784().checkOnesSegment("1001");
    }

    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }

    public boolean checkOnesSegment1(String s) {
        char[] ca = s.toCharArray();
        boolean flag = false;
        for (char c : ca) {
            if (c == '0') {
                flag = true;
            }
            if (flag && c == '1') {
                return false;
            }
        }
        return true;
    }
}
