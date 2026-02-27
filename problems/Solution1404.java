package leetcode.problems;

/*
给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
如果当前数字为偶数，则将其除以 2 。
如果当前数字为奇数，则将其加上 1 。
题目保证你总是可以按上述规则将测试用例变为 1 。
 */
class Solution1404 {

    static void main(String[] args) {
        new Solution1404().numSteps1("1101");
    }

    public int numSteps(String s) {
        int n = s.length();
        int ans = 0;
        // meet1 记录有没有遇到过'1'
        boolean meet1 = false;
        // 从后往前遍历
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                // 如果当前字符位0，分为2种情况
                // 1. 还没有遇到过'1'，那么这个0是字符串低位的0，需要一次[除2]操作
                // 2. 遇到过'1'，那么这个0是因为它右侧的某次[加1]操作变为1，因此他需要一次[加1]和一次[除2]操作
                ans += (meet1 ? 2 : 1);
            } else {
                // 如果当前字符位1，分为2种情况
                // 1. 还没有遇到过字符1，那么这个1需要一次[加1]操作和一次[除2]操作
                //    这里需要考虑一种特殊情况，就是这个1是字符串最左侧的1，他并不需要任何操作
                // 2. 遇见过字符1，那么这个1会因为他右侧的某次[加1]操作变为0，因此他只需要一次[除2]操作
                if (!meet1) {
                    if (i != 0) {
                        ans += 2;
                    }
                    meet1 = true;
                } else {
                    ans++;
                }

            }
        }
        return ans;
    }

    public int numSteps3(String s) {
        int steps = 0;
        StringBuilder sb = new StringBuilder(s);
        while (!sb.toString().equals("1")) {
            steps++;
            if (sb.charAt(sb.length() - 1) == '0') {
                // 偶数的情况
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // 找出最低位的0
                // 把这个0变成1，并将后面所有的1变成0，这样就实现了[+1]
                // 如果s中全是1，那么会有额外的进位
                for (int i = sb.length() - 1; i >= 0; i--) {
                    if (sb.charAt(i) == '1') {
                        sb.setCharAt(i, '0');
                        if (i == 0) {
                            sb.insert(0, '1');
                            break;
                        }
                    } else {
                        sb.setCharAt(i, '1');
                        break;
                    }
                }
            }
        }
        return steps;
    }

    public int numSteps2(String s) {
        int ans = s.length() - 1;
        int i = s.lastIndexOf('1');
        if (i > 0) {
            // 统计[1,i-1]中的'0'的个数
            for (int j = 1; j < i; j++) {
                ans += '1' - s.charAt(j);
            }
            ans += 2;
        }
        return ans;
    }

    public int numSteps1(String s) {
        char[] ca = s.toCharArray();
        int n = s.length();
        int ans = n - 1; // 除了最高位，其余每一位都要执行一次 [除以2]
        int carry = 0;
        for (int i = n - 1; i > 0; i--) {
            int sum = ca[i] - '0' + carry;
            ans += sum % 2; // 如果 ca[i] 变成1，需要执行 [加上1]
            carry = (sum + sum % 2) / 2;
        }
        // 如果在最高位还有进位，由于1+1=10 需要再执行一次 [除以2]
        return ans + carry;
    }
}
