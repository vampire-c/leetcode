package leetcode.problems;

class Solution1869 {

    static void main(String[] args) {
        new Solution1869().checkZeroOnes("1101");
    }

    public boolean checkZeroOnes(String s) {
        int zero = 0, one = 0;
        for (int i = 0, n = s.length(); i < n; ) {
            int st = i;
            char v = s.charAt(i);
            for (; i < n && s.charAt(i) == v; i++) {
            }
            if (v == '1') {
                one = Math.max(one, i - st);
            } else {
                zero = Math.max(zero, i - st);
            }
        }
        return one > zero;
    }

    public boolean checkZeroOnes1(String s) {
        char[] ca = s.toCharArray();
        int zero = 0, one = 0;
        char pre = '#';
        int cnt = 0;
        for (char c : ca) {
            if (c == pre) {
                cnt++;
            } else {
                if (pre == '0') {
                    zero = Math.max(zero, cnt);
                } else if (pre == '1') {
                    one = Math.max(one, cnt);
                }
                cnt = 1;
            }
            pre = c;
        }
        if (pre == '0') {
            zero = Math.max(zero, cnt);
        } else if (pre == '1') {
            one = Math.max(one, cnt);
        }
        return one > zero;
    }

}
