package leetcode.problems;

import java.util.Arrays;

class Solution0955 {

    public static void main(String[] args) {
        new Solution0955().minDeletionSize2(new String[]{"cba", "daf", "ghi"});
    }

    public int minDeletionSize2(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int size = n - 1;
        int[] checkList = new int[size];
        for (int i = 0; i < size; i++) {
            checkList[i] = i;
        }
        int ans = 0;
        next:
        for (int j = 0; j < m; j++) {
            for (int t = 0; t < size; t++) {
                int i = checkList[t];
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    ans++;
                    continue next;
                }
            }
            int newSize = 0;
            for (int t = 0; t < size; t++) {
                int i = checkList[t];
                if (strs[i].charAt(j) == strs[i + 1].charAt(j)) {
                    checkList[newSize++] = i;
                }
            }
            size = newSize;
        }
        return ans;
    }

    public int minDeletionSize1(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        String[] a = new String[n];
        Arrays.fill(a, "");

        int ans = 0;
        next:
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n - 1; i++) {
                if ((a[i] + strs[i].charAt(j)).compareTo
                        (a[i + 1] + strs[i + 1].charAt(j)) > 0) {
                    ans++;
                    continue next;
                }
            }

            for (int i = 0; i < n; i++) {
                a[i] += strs[i].charAt(j);
            }
        }
        return ans;
    }

    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        boolean[] flag = new boolean[n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            boolean keep = true;
            for (int j = 0; j < n - 1; j++) {
                if (!flag[j]) {
                    if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                        keep = false;
                        break;
                    }

                }
            }

            if (!keep) {
                ans++;
                continue;
            }

            for (int j = 0; j < n - 1; j++) {
                if (strs[j].charAt(i) < strs[j + 1].charAt(i)) {
                    flag[j] = true;
                }

            }

        }

        return ans;
    }
}
