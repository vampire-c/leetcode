package leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution2975 {

    public static void main(String[] args) {
        new Solution2975().maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2});
    }

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> hset = getSet(hFences, m);
        Set<Integer> vset = getSet(vFences, n);
        long ans = 0;
        for (Integer h : hset) {
            if (vset.contains(h)) {
                ans = Math.max(ans, h);
            }
        }

        return ans > 0 ? (int)((ans * ans) % 1000000007) : -1;
    }

    public Set<Integer> getSet(int[] fences, int l) {
        fences = Arrays.copyOf(fences, fences.length + 2);
        fences[fences.length - 1] = l;
        fences[fences.length - 2] = 1;
        Arrays.sort(fences);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fences.length; i++) {
            for (int j = i + 1; j < fences.length; j++) {
                set.add(fences[j] - fences[i]);
            }
        }
        return set;
    }
}
