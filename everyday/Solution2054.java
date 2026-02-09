package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution2054 {

    public static void main(String[] args) {
        new Solution2054().maxTwoEvents(new int[][]{{1, 3, 2}, {2, 4, 3}, {4, 5, 2}});
    }

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        ArrayList<int[]> st = new ArrayList<>();
        st.add(new int[]{0, 0});
        int ans = 0;
        for (int[] e : events) {
            int i = search(st, e[0]);
            int value = e[2];
            ans = Math.max(ans, st.get(i)[1] + value);
            if (value > st.getLast()[1]) {
                st.add(new int[]{e[1], value});
            }
        }
        return ans;
    }

    private int search(List<int[]> st, int target) {
        int left = -1, right = st.size();
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (st.get(mid)[0] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
