package leetcode.everyday;

public class Solution0009 {

    public static void main(String[] args) {
        new Solution0009().isPalindrome(121);
    }

    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        else if (x < 0 || x % 10 == 0) return false;
        int temp = x;
        int ans = 0;
        while (temp > 0) {
            ans = ans * 10 + temp % 10;
            temp /= 10;
        }
        return x == ans;
    }
}
