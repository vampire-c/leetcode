package leetcode.problems;

public class Solution0066 {

    public static void main(String[] args) {
        new Solution0066().plusOne(new int[]{9, 9, 9});
    }

    public int[] plusOne(int[] digits) {
        int l = digits.length;
        for (int i = l - 1; i >= 0; i--) {
            if (digits[i] != 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[l + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne1(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }

        boolean p1 = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9 && p1) {
                digits[i] = 0;
            } else if (digits[i] != 9 && p1) {
                digits[i]++;
                p1 = false;
                break;
            }
        }
        if (digits[0] == 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            System.arraycopy(digits, 0, ans, 1, digits.length);
            return ans;
        }
        return digits;
    }
}
