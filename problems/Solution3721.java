package leetcode.problems;

import java.util.*;

class LazyTag {
    int toAdd;

    LazyTag() {
        this.toAdd = 0;
    }

    LazyTag add(LazyTag other) {
        this.toAdd += other.toAdd;
        return this;
    }

    boolean hasTag() {
        return this.toAdd != 0;
    }

    void clear() {
        this.toAdd = 0;
    }
}

class SegmentTreeNode {
    int minValue;
    int maxValue;
    LazyTag lazyTag;

    SegmentTreeNode() {
        this.minValue = 0;
        this.maxValue = 0;
        this.lazyTag = new LazyTag();
    }
}

class SegmentTree {
    private int n;
    private SegmentTreeNode[] tree;

    SegmentTree(int[] data) {
        this.n = data.length;
        this.tree = new SegmentTreeNode[this.n * 4 + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new SegmentTreeNode();
        }
        build(data, 1, this.n, 1);
    }

    void add(int l, int r, int val) {
        LazyTag tag = new LazyTag();
        tag.toAdd = val;
        update(l, r, tag, 1, this.n, 1);
    }

    int findLast(int start, int val) {
        if (start > this.n) {
            return -1;
        }
        return find(start, this.n, val, 1, this.n, 1);
    }

    private void applyTag(int i, LazyTag tag) {
        tree[i].minValue += tag.toAdd;
        tree[i].maxValue += tag.toAdd;
        tree[i].lazyTag.add(tag);
    }

    private void pushdown(int i) {
        if (tree[i].lazyTag.hasTag()) {
            LazyTag tag = new LazyTag();
            tag.toAdd = tree[i].lazyTag.toAdd;
            applyTag(i << 1, tag);
            applyTag((i << 1) | 1, tag);
            tree[i].lazyTag.clear();
        }
    }

    private void pushup(int i) {
        tree[i].minValue = Math.min(tree[i << 1].minValue, tree[(i << 1) | 1].minValue);
        tree[i].maxValue = Math.max(tree[i << 1].maxValue, tree[(i << 1) | 1].maxValue);
    }

    private void build(int[] data, int l, int r, int i) {
        if (l == r) {
            tree[i].minValue = tree[i].maxValue = data[l - 1];
            return;
        }
        int mid = l + (r - l) / 2;
        build(data, l, mid, i << 1);
        build(data, mid + 1, r, (i << 1) | 1);
        pushup(i);
    }

    private void update(int targetL, int targetR, LazyTag tag, int l, int r, int i) {
        if (targetL <= l && r <= targetR) {
            applyTag(i, tag);
            return;
        }
        pushdown(i);
        int mid = l + (r - l) / 2;
        if (targetL <= mid) {
            update(targetL, targetR, tag, l, mid, i << 1);
        }
        if (targetR > mid) {
            update(targetL, targetR, tag, mid + 1, r, (i << 1) | 1);
        }
        pushup(i);
    }

    private int find(int targetL, int targetR, int val, int l, int r, int i) {
        if (tree[i].minValue > val || tree[i].maxValue < val) {
            return -1;
        }
        if (l == r) {
            return l;
        }
        pushdown(i);
        int mid = l + (r - l) / 2;
        if (targetR >= mid + 1) {
            int res = find(targetL, targetR, val, mid + 1, r, (i << 1) | 1);
            if (res != -1) {
                return res;
            }
        }
        if (l <= targetR && mid >= targetL) {
            return find(targetL, targetR, val, l, mid, i << 1);
        }
        return -1;
    }

}

class LazySegmentTree {
    private static final class Node {
        int min;
        int max;
        int todo;
    }

    private void apply(int node, int todo) {
        Node cur = tree[node];
        cur.min += todo;
        cur.max += todo;
        cur.todo += todo;
    }

    private final int n;
    private final Node[] tree;

    public LazySegmentTree(int n) {
        this.n = n;
        tree = new Node[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
        Arrays.setAll(tree, _ -> new Node());
    }

    public void update(int ql, int qr, int f) {
        update(1, 0, n - 1, ql, qr, f);
    }

    public int findFirst(int ql, int qr, int target) {
        return findFirst(1, 0, n - 1, ql, qr, target);
    }

    private void spread(int node) {
        int todo = tree[node].todo;
        if (todo == 0) {
            return;
        }
        apply(node * 2, todo);
        apply(node * 2 + 1, todo);
        tree[node].todo = 0;
    }

    private void maintain(int node) {
        tree[node].min = Math.min(tree[node * 2].min, tree[node * 2 + 1].min);
        tree[node].max = Math.max(tree[node * 2].max, tree[node * 2 + 1].max);
    }

    private void update(int node, int l, int r, int ql, int qr, int f) {
        if (ql <= l && r <= qr) {
            apply(node, f);
            return;
        }
        spread(node);
        int m = l + (r - l) / 2;
        if (ql <= m) {
            update(node * 2, l, m, ql, qr, f);
        }
        if (qr > m) {
            update(node * 2 + 1, m + 1, r, ql, qr, f);
        }
        maintain(node);
    }

    private int findFirst(int node, int l, int r, int ql, int qr, int target) {
        if (l > qr || r < ql || target < tree[node].min || target > tree[node].max) {
            return -1;
        }
        if (l == r) {
            return l;
        }
        spread(node);
        int m = l + (r - l) / 2;
        int idx = findFirst(node * 2, l, m, ql, qr, target);
        if (idx < 0) {
            idx = findFirst(node * 2 + 1, m + 1, r, ql, qr, target);
        }
        return idx;
    }
}


class Solution3721 {

    static void main(String[] args) {
        new Solution3721().longestBalanced(new int[]{2, 5, 4, 3});
    }

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        LazySegmentTree t = new LazySegmentTree(n + 1);

        Map<Integer, Integer> last = new HashMap<>();
        int ans = 0;
        int curSum = 0;

        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            int v = x % 2 > 0 ? 1 : -1;
            Integer j = last.get(x);
            if (j == null) {
                curSum += v;
                t.update(i, n, v);
            } else {
                t.update(j, i - 1, -v);
            }
            last.put(x, i);

            int l = t.findFirst(0, i - 1 - ans, curSum);
            if (l >= 0) {
                ans = i - j;
            }
        }

        return ans;
    }

    public int longestBalanced1(int[] nums) {
        Map<Integer, Queue<Integer>> occurrences = new HashMap<>();

        int len = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = sgn(nums[0]);
        occurrences.computeIfAbsent(nums[0], k -> new LinkedList<>()).add(1);

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1];
            Queue<Integer> occ = occurrences.computeIfAbsent(nums[i], k -> new LinkedList<>());
            if (occ.isEmpty()) {
                prefixSum[i] += sgn(nums[i]);
            }
            occ.add(i + 1);
        }

        SegmentTree seg = new SegmentTree(prefixSum);

        for (int i = 0; i < nums.length; i++) {
            len = Math.max(len, seg.findLast(i + len, 0) - i);
            int nextPos = nums.length + 1;
            occurrences.get(nums[i]).poll();
            if (!occurrences.get(nums[i]).isEmpty()) {
                nextPos = occurrences.get(nums[i]).peek();
            }
            seg.add(i + 1, nextPos - 1, -sgn(nums[i]));
        }

        return len;
    }

    private int sgn(int num) {
        return (num % 2) == 0 ? 1 : -1;
    }

}
