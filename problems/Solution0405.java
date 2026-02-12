package leetcode.problems;

/*
给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
答案字符串中的所有字母都应该是小写字符，并且除了 0 本身之外，答案中不应该有任何前置零。
注意: 不允许使用任何由库提供的将数字直接转换或格式化为十六进制的方法来解决这个问题。
 */
class Solution0405 {

    static void main(String[] args) {
        String hex = new Solution0405().toHex(-26);
        System.out.println(hex);
    }

    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num !=0) {
            int u = num & 15;
            char c = (char) (u + '0');
            if (u >= 10) {
                c = (char) (u - 10 + 'a');
            }
            sb.insert(0, c);
            num >>>= 4;
        }
        return sb.toString();
    }

    public String toHex3(int num) {
        if (num == 0) return "0";
        long number = num;
        StringBuilder sb = new StringBuilder();
        if (number < 0) {
            number = (long) (Math.pow(2, 32) + number);
        }
        while (number != 0) {
            long u = number % 16;
            char c = (char) (u + '0');
            if (u >= 10) {
                c = (char) (u - 10 + 'a');
            }
            sb.insert(0, c);
            number /= 16;
        }
        return sb.toString();
    }

    public String toHex2(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i > 0; i--) {
            int val = (num >> (4 * i)) & 0xf;
            if (!sb.isEmpty() || val > 0) {
                char c = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String toHex1(int num) {
        char[] hexane = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.insert(0, hexane[num & 15]);
            num >>>= 4;
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}
