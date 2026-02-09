package leetcode.problems;

class Solution0125 {

    static void main(String[] args) {
        new Solution0125().isPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char lc = s.charAt(left);
            char rc = s.charAt(right);
            if (!((lc >= '0' && lc <= '9') || (lc >= 'a' && lc <= 'z') || (lc >= 'A' && lc <= 'Z'))) {
                left++;
                continue;
            }
            if (!(((rc >= '0' && rc <= '9') || (rc >= 'a' && rc <= 'z') || (rc >= 'A' && rc <= 'Z')))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
