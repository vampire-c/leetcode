package leetcode.everyday;

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
