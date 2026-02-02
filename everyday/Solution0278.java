package leetcode.problems;
/*
The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);
*/

import leetcode.VersionControl;

public class Solution0278 extends VersionControl {

    static void main(String[] args) {
        new Solution0278().firstBadVersion(25);
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


}
