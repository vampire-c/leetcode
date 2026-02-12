package leetcode.problems;

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
