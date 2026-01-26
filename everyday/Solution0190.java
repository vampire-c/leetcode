package leetcode.everyday;

class Solution0190 {

    static void main(String[] args) {
        int i = new Solution0190().reverseBits(43261596);
        System.out.println(i);
    }

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= n & 1;
            n >>= 1;
        }
        return ans;
    }

    public int reverseBits1(int n) {
        String format = String.format("%32s", Integer.toBinaryString(n)).replace(" ", "0");
        StringBuilder str = new StringBuilder();
        for (int i = format.length() - 1; i >= 0; i--) {
            char c = format.charAt(i);
            str.append(c);
        }
        return Integer.parseInt(str.toString(), 2);
    }
}
