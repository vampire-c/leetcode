package leetcode.problems;

/*
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 */
class Solution0415 {

    static void main(String[] args) {
        new Solution0415().addStrings1("11", "123");
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        char[] ca1 = num1.toCharArray();
        char[] ca2 = num2.toCharArray();
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? ca1[i] - '0' : 0;
            int y = j >= 0 ? ca2[j] - '0' : 0;
            int result = x + y + add;
            sb.append(result % 10);

            add = result / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    public String addStrings1(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int l = Math.max(l1, l2) + 1;
        StringBuilder sb = new StringBuilder();
        if (l1 > l2) {
            for (int i = 0; i < l1 - l2; i++) {
                sb.append("0");
            }
            num2 = sb.append(num2).toString();
        } else if (l1 < l2) {
            for (int i = 0; i < l2 - l1; i++) {
                sb.append("0");
            }
            num1 = sb.append(num1).toString();
        }
        num1 = "0" + num1;
        num2 = "0" + num2;
        sb.setLength(0);
        char[] ca1 = num1.toCharArray();
        char[] ca2 = num2.toCharArray();
        for (int i = l - 1; i >= 0; i--) {
            int x = ca1[i] - '0' + ca2[i] - '0';
            if (x >= 10) {
                sb.append(x % 10);
                ca1[i - 1] += 1;
            } else {
                sb.append(x);
            }
        }
        sb.reverse();
        if ("0".equals(String.valueOf(sb.charAt(0)))) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
