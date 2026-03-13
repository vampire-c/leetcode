package leetcode.problems;

/*
给你一个字符串 s，最多 可以从中删除一个字符。
请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 */
class Solution0680 {

    static void main(String[] args) {
        // new Solution0680().validPalindrome("aba");
        boolean b = new Solution0680().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
        System.out.println(b);
    }

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public boolean validPalindrome1(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return validPalindromeTest(s) || validPalindromeTest(sb.toString());
    }

    public boolean validPalindromeTest(String s) {
        char[] ca = s.toCharArray();
        int count = 0;
        for (int left = 0, right = ca.length - 1; left < right; ) {
            char cl = ca[left];
            char cr = ca[right];
            if (count > 1) {
                return false;
            }
            if (ca[left] == ca[right]) {
                left++;
                right--;
            } else if (ca[left + 1] == ca[right]) {
                count++;
                left += 2;
                right--;
            } else if (ca[left] == ca[right - 1]) {
                count++;
                left++;
                right -= 2;
            } else {
                return false;
            }
        }
        return count <= 1;
    }

}
