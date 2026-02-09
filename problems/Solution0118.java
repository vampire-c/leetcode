package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

class Solution0118 {

    static void main(String[] args) {
        new Solution0118().generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        ans.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>(i + 1);
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }
}
