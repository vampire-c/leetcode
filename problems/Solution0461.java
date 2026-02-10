package leetcode.problems;

class Solution0461 {

    static void main(String[] args) {
        new Solution0461().hammingDistance(1, 4);
    }

    public int hammingDistance(int x, int y) {
        int ans = 0;
        for (int i = x ^ y; i > 0; i -= (i & -i)) {
            ans++;
        }
        return ans;
    }

    public int hammingDistance2(int x, int y) {
        int ans = 0;
        while ((x | y) != 0) {
            int a = x & 1;
            int b = y & 1;
            ans += a ^ b;
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
