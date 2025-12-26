package leetcode.everyday;

class Solution2483 {

    public static void main(String[] args) {
        new Solution2483().bestClosingTime1("YYNY");

    }

    public int bestClosingTime1(String customers) {
        // 1101     1101 1101 1101 1101
        // 0000     1000 1100 1110 1111
        // 0

        // 1101     0101 0001 0011 0010

        int l = customers.length();
        customers = customers.replaceAll("Y", "1").replaceAll("N", "0");
        Integer c = Integer.parseInt(customers, 2);
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));
        for (int i = 0; i <= l; i++) {
            String s = "1".repeat(i) + "0".repeat(l - i);
            Integer z = Integer.parseInt(s, 2);
            Integer ans = c ^ z;
            // todo
        }
        return 0;
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
                t = Math.min(t, i);
            }
        }
        return t;
    }
}
