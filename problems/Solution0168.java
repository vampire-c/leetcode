package leetcode.problems;

/*
给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
例如：
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 */
class Solution0168 {

    static void main(String[] args) {
        String s = new Solution0168().convertToTitle(2147483647);
        System.out.println(s);
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.insert(0, (char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return sb.toString();
    }
}
