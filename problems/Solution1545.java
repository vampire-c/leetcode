package leetcode.problems;

/*
给你两个正整数 n 和 k，二进制字符串  Sn 的形成规则如下：
S1 = "0"
当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1))
其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）。
例如，符合上述描述的序列的前 4 个字符串依次是：
S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
请你返回  Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内。
 */
class Solution1545 {

    static void main(String[] args) {
        char kthBit = new Solution1545().findKthBit(4, 11);
        System.out.println(kthBit);
    }

    public char findKthBit(int n, int k) {
        if (k%2>0){
            return (char) ('0' + k / 2 % 2);
        }
        k /= k & -k;
        return (char) ('1' - k / 2 % 2);
    }

    public char findKthBit3(int n, int k) {
        int rev = 0;
        while (true) {
            if (n == 1) {
                return (char) ('0' ^ rev);
            }
            if (k == 1 << (n - 1)) {
                return (char) ('1' ^ rev);
            }
            if (k > 1 << (n - 1)) {
                k = (1 << n) - k;
                rev ^= 1;
            }
            n--;
        }
    }

    public char findKthBit2(int n, int k) {
        if (n == 1) {
            return '0';
        }
        if (k == 1 << (n - 1)) {
            return '1';
        }
        if (k < 1 << (n - 1)) {
            return findKthBit(n - 1, k);
        }
        char res = findKthBit(n - 1, (1 << n) - k);
        return (char) (res ^ 1);
    }

    public char findKthBit1(int n, int k) {
        return findKthBit(n).charAt(k - 1);
    }

    public String findKthBit(int n) {
        if (n == 1) {
            return "0";
        }
        String kthBit = findKthBit(n - 1);
        char[] ca = kthBit.toCharArray();
        for (int i = ca.length - 1; i >= 0; i--) {
            if (ca[i] == '0') {
                ca[i] = '1';
            } else {
                ca[i] = '0';
            }
        }
        for (int left = 0, right = ca.length - 1; left < right; left++, right--) {
            char temp = ca[left];
            ca[left] = ca[right];
            ca[right] = temp;
        }
        return kthBit + "1" + new String(ca);
    }

}
