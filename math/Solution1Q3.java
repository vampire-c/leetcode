package leetcode.math;

class Solution1Q3 {

    public static void main(String[] args) {
        new Solution1Q3().isPalindrome(121);
    }

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        } else if (x < 0 || x % 10 == 0) {
            return false;
        }
        int temp = x;
        int ans = 0;
        while (temp > 0) {
            ans = ans * 10 + temp % 10;
            temp /= 10;
        }
        return x == ans;
    }
}
