package leetcode.everyday;

public class Solution0067 {

    public static void main(String[] args) {
        new Solution0067().addBinary("10101", "1011");
    }

    public String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();
        StringBuilder ans = new StringBuilder();
        int n = Math.max(al, bl);
        int carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < al ? (a.charAt(al - 1 - i) - '0') : 0;
            carry += i < bl ? (b.charAt(bl - 1 - i) - '0') : 0;
            ans.insert(0, (char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            ans.insert(0, '1');
        }
        return ans.toString();
    }

    public String addBinary1(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) ^ Integer.parseInt(b, 2)
        );
    }
}
