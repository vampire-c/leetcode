package leetcode.everyday;

class Solution2483 {

    public static void main(String[] args) {
        new Solution2483().bestClosingTime33("YYNY");

    }

    public int bestClosingTime33(String customers) {
        int penalty = 0;
        int minPenalty = 0;
        int t = 0;
        for (int i = 0; i < customers.length(); i++) {
            penalty += customers.charAt(i) == 'N' ? 1 : -1;
            if (penalty < minPenalty) {
                minPenalty = penalty;
                t = i + 1;
            }
        }
        return t;
    }

    public int bestClosingTime3(String customers) {
        char[] s = customers.toCharArray();
        int penalty = 0;
        for (char c : s) {
            if (c == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int t = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 'Y') {
                penalty--;
            } else {
                penalty++;
            }

            if (minPenalty < penalty) {
                minPenalty = penalty;
                t = i + 1;
            }

        }

        return t;
    }

    public int bestClosingTime2(String customers) {
        int l = customers.length();
        char[] s = customers.toCharArray();
        int yl = 0;
        for (char c : s) {
            if (c == 'Y') {
                yl++;
            }
        }
        int nl = l - yl;

        // int ly = 0;
        int ln = 0;
        int ry = yl;
        // int rn = nl;

        int d = ln + ry;
        int t = 0;
        for (int i = 0; i < l; i++) {
            if (customers.charAt(i) == 'Y') {
                // ly++;
                ry--;
            } else {
                ln++;
                // rn--;
            }
            int tmp = ln + ry;
            if (tmp < d) {
                d = tmp;
                t = i + 1;
            } else if (tmp == d) {
                t = Math.min(t, i + 1);
            }
        }

        return t;
    }

    public int bestClosingTime1(String customers) {
        // 1101 1101 1101 1101 1101
        // 0000 1000 1100 1110 1111
        // 0

        // 1101 0101 0001 0011 0010

        int l = customers.length();
        customers = customers.replaceAll("Y", "1").replaceAll("N", "0");
        Integer c = Integer.parseInt(customers, 2);
        int d = l + 1;
        int t = l + 1;
        for (int i = 0; i <= l; i++) {
            String s = "1".repeat(i) + "0".repeat(l - i);
            Integer z = Integer.parseInt(s, 2);
            Integer ans = c ^ z;
            String binaryString = Integer.toBinaryString(ans);
            int count = 0;
            for (int j = 0; j < binaryString.length(); j++) {
                if (binaryString.charAt(j) == '1') {
                    count++;
                }
            }
            if (count < d) {
                d = count;
                t = i;
            } else if (count == d) {
                t = Math.min(t, i);
            }
        }
        return t;
    }

    public int bestClosingTime(String customers) {
        int n = customers.length();
        int d = n + 1, t = n;
        for (int i = 0; i <= n; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                char c = customers.charAt(j);
                if (i <= j) {
                    if (c == 'Y') {
                        tmp++;
                    }
                } else {
                    if (c == 'N') {
                        tmp++;
                    }
                }
            }
            if (tmp < d) {
                d = tmp;
                t = i;
            } else if (tmp == d) {
                // t = Math.min(t, i);
                return t;
            }
        }
        return t;
    }
}
