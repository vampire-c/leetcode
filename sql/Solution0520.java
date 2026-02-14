package leetcode.problems;

/*
我们定义，在以下情况时，单词的大写用法是正确的：
全部字母都是大写，比如 "USA" 。
所有字母都不是大写，比如 "leetcode" 。
只有首字母大写， 比如 "Google" 。
给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 */
class Solution0520 {

    static void main(String[] args) {
        // new Solution0520().detectCapitalUse("USA");
        new Solution0520().detectCapitalUse("ffffffffffffffffffffF");
    }

    public boolean detectCapitalUse(String word) {
        char[] ca = word.toCharArray();
        int l = ca.length;
        int i = 0;
        for (char c : ca) {
            if (c >= 'A' && c <= 'Z') i++;
        }
        return i == 0 || i == l || (i == 1 && Character.isUpperCase(ca[0]));
    }

    public boolean detectCapitalUse2(String word) {
        if (word.equals(word.toLowerCase()) || word.equals(word.toUpperCase())) {
            return true;
        }
        char[] ca = word.toCharArray();
        if (Character.isUpperCase(ca[0])) {
            for (int i = 1; i < ca.length; i++) {
                if (Character.isUpperCase(ca[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean detectCapitalUse1(String word) {
        if (word.length() == 1) return true;
        char[] ca = word.toCharArray();
        if (ca[0] >= 'A' && ca[0] <= 'Z') {
            if (ca[1] >= 'A' && ca[1] <= 'Z') {
                return chack(ca, true, 2);
            } else if (ca[1] >= 'a' && ca[1] <= 'z') {
                return chack(ca, false, 2);
            }
        } else if (ca[0] >= 'a' && ca[0] <= 'z') {
            return chack(ca, false, 1);
        }
        return false;
    }

    private boolean chack(char[] ca, boolean b, int i) {
        if (b) {
            while (i < ca.length) {
                if (ca[i] >= 'A' && ca[i] <= 'Z') {
                    i++;
                    continue;
                }
                return false;
            }
        } else {
            while (i < ca.length) {
                if (ca[i] >= 'a' && ca[i] <= 'z') {
                    i++;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
