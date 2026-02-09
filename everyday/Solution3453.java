package leetcode.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution3453 {
    public static void main(String[] args) {
        new Solution3453().separateSquares(new int[][]{{0, 0, 2}, {1, 1, 1}});
    }


    public double separateSquares(int[][] squares) {
        long total_area = 0;
        List<int[]> events = new ArrayList<>();

        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            total_area += (long) l * l;
            events.add(new int[]{y, l, 1});
            events.add(new int[]{y + l, l, -1});
        }

        events.sort(Comparator.comparingInt(a -> a[0]));
        double covered_width = 0; // 当前扫描线下所有底边之和
        double curr_area = 0; // 当前累计面积
        double prev_height = 0; // 前一个扫描线的高度

        for (int[] event : events) {
            int y = event[0];
            int l = event[1];
            int delta = event[2];

            int diff = y - (int) prev_height; // 两条扫描线之间新增的面积
            double area = covered_width * diff; // 如果加上这部分面积超过总面积的一半

            if (2L * (curr_area + area) >= total_area) {
                return prev_height + (total_area - 2.0 * curr_area) / (2.0 * covered_width);
            }
            // 更新宽度，开始事件加宽度，结束事件减宽度
            covered_width += delta * l;
            curr_area += area;
            prev_height = y;
        }

        return 0.0;
    }

    public double separateSquares1(int[][] squares) {
        double height = 0;
        double end = 0;
        double total_area = 0;
        double eps = 1e-5;
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            total_area += (double) l * l;
            height = Math.max(height, (double) (y + l));
        }
        total_area /= 2;
        while (Math.abs(height - end) > eps) {
            double mid = (height + end) / 2;
            if (check(mid, squares, total_area)) {
                height = mid;
            } else {
                end = mid;
            }
        }
        return height;
    }

    public Boolean check(double limit_y, int[][] squares, double total_area) {
        double area = 0;
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            if (y < limit_y) {
                area += (double) l * Math.min(limit_y - y, (double) l);
            }
        }
        return area >= total_area;
    }


}
