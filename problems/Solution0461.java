package leetcode.problems;

/*
两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 */
class Solution0461 {

    static void main(String[] args) {
        new Solution0461().hammingDistance2(1, 4);
    }

    public int hammingDistance(int x, int y) {
        int s = x ^ y;
        int ans = 0;
        while (s != 0) {
            s &= (s - 1);
            /*
                  s = 10001000
                x-1 = 10000111
            x&(x-1) = 10000000
            相当于删掉最右侧的1
             */
            ans++;
        }
        return ans;
    }

    public int hammingDistance5(int x, int y) {
        int s = x ^ y;
        int ans = 0;
        while (s != 0) {
            ans += s & 1;
            /*
              s = 10001000
              1 = 00000001
            s&1 = 00000000
             */
            s >>= 1;
        }
        return ans;
    }

    public int hammingDistance4(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance3(int x, int y) {
        int ans = 0;
        int s = x ^ y;
        while (s > 0) {
            s -= (s & -s);
            ans++;
        }
        return ans;
    }

    public int hammingDistance2(int x, int y) {
        int ans = 0;
        while ((x | y) != 0) {
            ans += (x & 1) ^ (y & 1);
            x >>= 1;
            y >>= 1;
        }
        return ans;
    }

    public int hammingDistance1(int x, int y) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int a = (x >> i) & 1;
            int b = (y >> i) & 1;
            ans += a ^ b;
        }
        return ans;
    }
}
