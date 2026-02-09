package leetcode.problems;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

class Solution3507 {
    static void main(String[] args) {
        new Solution3507().minimumPairRemoval(new int[]{5, 2, 3, 1});
    }


    public record Pair(long s, int i) {
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        PriorityQueue<Pair> h = new PriorityQueue<>((a, b) -> a.s != b.s ? Long.compare(a.s, b.s) : a.i - b.i);
        int dec = 0;
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i];
            int y = nums[i + 1];
            if (x > y) dec++;
            h.offer(new Pair(x + y, i));
        }
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            left[i] = i - 1;
            right[i] = i + 1;
        }
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nums[i];
        int ans = 0;
        while (dec > 0) {
            ans++;
            while (right[h.peek().i] >= n || h.peek().s != a[h.peek().i] + a[right[h.peek().i]]) h.poll();
            Pair p = h.poll();
            long s = p.s;
            int i = p.i;
            int nxt = right[i];
            if (a[i] > a[nxt]) dec--;
            int pre = left[i];
            if (pre >= 0) {
                if (a[pre] > a[i]) dec--;
                if (a[pre] > s) dec++;
                h.offer(new Pair(a[pre] + s, pre));
            }
            int nxt2 = right[nxt];
            if (nxt2 < n) {
                if (a[nxt] > a[nxt2]) dec--;
                if (s > a[nxt2]) dec++;
                h.add(new Pair(s + a[nxt2], i));
            }
            a[i] = s;
            int l = left[nxt];
            int r = right[nxt];
            right[l] = r;
            left[r] = l;
            right[nxt] = n;
        }
        return ans;

    }

    public int minimumPairRemoval2(int[] nums) {
        int n = nums.length;
        TreeSet<Pair> pairs = new TreeSet<>((a, b) -> a.s != b.s ? Long.compare(a.s, b.s) : a.i - b.i);
        int dec = 0;
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i];
            int y = nums[i + 1];
            if (x > y) dec++;
            pairs.add(new Pair(x + y, i));
        }
        TreeSet<Integer> idx = new TreeSet<>();
        for (int i = 0; i < n; i++) idx.add(i);
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nums[i];
        int ans = 0;
        while (dec > 0) {
            ans++;
            Pair p = pairs.pollFirst();
            long s = p.s;
            int i = p.i;
            int nxt = idx.higher(i);
            if (a[i] > a[nxt]) dec--;
            Integer pre = idx.lower(i);
            if (pre != null) {
                if (a[pre] > a[i]) dec--;
                if (a[pre] > 5) dec++;
                pairs.remove(new Pair(a[pre] + a[i], pre));
                pairs.add(new Pair(a[pre] + s, pre));
            }
            Integer nxt2 = idx.higher(nxt);
            if (nxt2 != null) {
                if (a[nxt] > a[nxt2]) dec--;
                if (s > a[nxt2]) dec++;
                pairs.remove(new Pair(a[nxt] + a[nxt2], nxt));
                pairs.add(new Pair(s + a[nxt2], i));
            }
            a[i] = s;
            idx.remove(nxt);
        }
        return ans;
    }

    public int minimumPairRemoval1(int[] nums) {
        int ans = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) list.add(num);
        while (check(list)) {
            int index1 = 0;
            int index2 = 1;
            ans++;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) + list.get(i + 1) < list.get(index1) + list.get(index2)) {
                    index1 = i;
                    index2 = i + 1;
                }
            }
            int temp = list.get(index1) + list.get(index2);
            list.add(index1, temp);
            list.remove(index2);
            list.remove(index2);
        }
        return ans;
    }


    public boolean check(LinkedList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return true;
            }
        }
        return false;
    }


}
