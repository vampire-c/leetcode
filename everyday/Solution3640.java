package leetcode.problems;

class Solution3640 {

    static void main(String[] args) {
        new Solution3640().maxSumTrionic(new int[]{0, -2, -1, -3, 0, 2, -1});
        //`0``````````0`2``````````````````
        //``````-1````````-1```````````````
        //```-2````-3``````````````````````

        new Solution3640().maxSumTrionic(new int[]{0, -2, -1, -3, -2, -1, 0, 2, -1, 2, 3, 4, 0});
        // ````````````````````2````2`3`4```
        // `0````````````````0````````````0`
        // ``````-1```````-1`````-1`````````
        // ```-2````-3`-2```````````````````
    }

    public long maxSumTrionic(int[] nums) {
        final long NEG_INF = Long.MIN_VALUE / 2;
        long ans = NEG_INF;
        long f1 = NEG_INF;
        long f2 = NEG_INF;
        long f3 = NEG_INF;
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i - 1];
            int y = nums[i];
            f3 = x < y ? Math.max(f3, f2) + y : NEG_INF;
            f2 = x > y ? Math.max(f2, f1) + y : NEG_INF;
            f1 = x < y ? Math.max(f1, x) + y : NEG_INF;
            ans = Math.max(ans, f3);
        }
        return ans;
    }

    public long maxSumTrionic1(int[] nums) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; ) {
            // 第一段
            int start = i;

            i++;
            for (; i < n && nums[i - 1] < nums[i]; ) {
                i++;
            }

            if (i == start + 1) { // 第一段至少两个元素
                continue;
            }

            // 第二段
            int peak = i - 1;
            long res = nums[peak - 1] + nums[peak]; // 第一段最后两个元素必选
            for (; i < n && nums[i - 1] > nums[i]; ) {
                res += nums[i]; // 第二段所有元素必选
                i++;
            }
            if (i == peak + 1 || i == n || nums[i - 1] == nums[i]) { // 第二段至少两个元素，第三段至少两个元素
                continue;
            }

            // 第三段
            int bottom = i - 1;
            res += nums[i]; // 第三段的前两个数必选，第一个数在第二段循环中已添加
            // 第三段的第三个数往右求和，找最大值
            long maxS = 0;
            long s = 0;

            i++;
            for (; i < n && nums[i - 1] < nums[i]; ) {
                s += nums[i];
                maxS = Math.max(maxS, s);
                i++;
            }
            res += maxS;

            // 第一段倒数第三个往左求和，找最大值
            maxS = 0;
            s = 0;

            int j = peak - 2;
            for (; j >= start; ) {
                s += nums[j];
                maxS = Math.max(maxS, s);
                j--;
            }

            res += maxS;
            ans = Math.max(ans, res);

            i = bottom; // 第三段的起点也是下一个三段式数组的第一段的起点
        }
        return ans;
    }
}
