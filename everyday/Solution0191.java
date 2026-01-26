package leetcode.everyday;

class Solution0191 {

    static void main(String[] args) {
        new Solution0191().hammingWeight(11);
    }

    public int hammingWeight(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }

    public int hammingWeight1(int n) {
        String binaryString = Integer.toBinaryString(n);
        binaryString = binaryString.replaceAll("0", "");
        return binaryString.length();
    }
}
