package leetcode.problems;

class Solution0258 {

    static void main(String[] args) {
        new Solution0258().addDigits(38);
    }

    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public int addDigits2(int num) {
        while (num >= 10) {
            int ans = 0;
            while (num > 0) {
                ans += num % 10;
                num /= 10;
            }
            num = ans;
        }
        return num;
    }

    public int addDigits1(int num) {
        if (num < 10) {
            return num;
        }
        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num /= 10;
        }
        return addDigits1(ans);
    }
}
