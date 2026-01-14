package leetcode.everyday;

public class Solution1317 {

    public static void main(String[] args) {
        new Solution1317().getNoZeroIntegers(1011);
    }

    public int[] getNoZeroIntegers(int n) {
        int a = 0;
        int base = 1;
        for (int x = n; x > 1; x = x / 10) {
            int d = x % 10;
            if (d <= 1) {
                d = d + 10;
                x = x - 10;
            }
            a = a + d / 2 * base;
            base = base * 10;
        }
        return new int[]{a, n - a};
    }

    public int[] getNoZeroIntegers1(int n) {
        int x = 0;
        int y = n - x;
        while (hasZero(x) || hasZero(y)) {
            x++;
            y = n - x;
        }
        return new int[]{x, y};
    }


    public boolean hasZero(int num) {
        if (num == 0) return true;
        while (num > 0) {
            if (num % 10 == 0) {
                return true; // 发现个位数为0
            }
            num /= 10; // 去掉最后一位
        }
        return false; // 没有发现0
    }
}
