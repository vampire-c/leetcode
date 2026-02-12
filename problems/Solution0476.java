package leetcode.problems;

/*
对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
给你一个整数 num ，输出它的补数。
 */
class Solution0476 {

    static void main(String[] args) {
        new Solution0476().findComplement(5);

    }

    public int findComplement(int num) {
        int s = -1;
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) != 0) {
                s = i;
                break;
            }
        }
        int ans = 0;
        for (int i = 0; i < s; i++) {
            if (((num >> i) & 1) == 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public int findComplement2(int num) {
        int highbit = 0;
        for (int i = 1; i <= 30; i++) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }

    public int findComplement1(int num) {
        int ans = 0;
        int i = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                ans += (int) Math.pow(2, i);
            }
            i++;
            num = num >> 1;
        }
        return ans;
    }
}
