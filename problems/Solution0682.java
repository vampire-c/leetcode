package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/*
你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
1. 整数 x - 表示本回合新获得分数 x
2. "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
3. "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
4. "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
请你返回记录中所有得分的总和。
 */
class Solution0682 {

    static void main(String[] args) {
        new Solution0682().calPoints(new String[]{"5", "2", "C", "D", "+"});
        // new Solution0682().calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"});
    }

    public int calPoints(String[] operations) {
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        for (String op : operations) {
            int size = list.size();
            switch (op.charAt(0)) {
                case '+':
                    ans += list.get(size - 2) + list.get(size - 1);
                    list.add(list.get(size - 2) + list.get(size - 1));
                    break;
                case 'D':
                    ans += list.get(size - 1) * 2;
                    list.add(list.get(size - 1) * 2);
                    break;
                case 'C':
                    ans -= list.get(size - 1);
                    list.remove(size - 1);
                    break;
                default:
                    ans += Integer.parseInt(op);
                    list.add(Integer.parseInt(op));
            }
        }
        return ans;
    }

    public int calPoints1(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for (String op : operations) {
            switch (op.charAt(0)) {
                case '+':
                    list.add(list.get(list.size() - 2) + list.getLast());
                    break;
                case 'D':
                    list.add(list.getLast() * 2);
                    break;
                case 'C':
                    list.removeLast();
                    break;
                default:
                    list.add(Integer.parseInt(op));
            }
        }
        int ans = 0;
        for (int i : list) {
            ans += i;
        }
        return ans;
    }
}
