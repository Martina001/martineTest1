//假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ： 
//
// 
// perm[i] 能够被 i 整除 
// i 能够被 perm[i] 整除 
// 
//
// 给你一个整数 n ，返回可以构造的 优美排列 的 数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：
//第 1 个优美的排列是 [1,2]：
//    - perm[1] = 1 能被 i = 1 整除
//    - perm[2] = 2 能被 i = 2 整除
//第 2 个优美的排列是 [2,1]:
//    - perm[1] = 2 能被 i = 1 整除
//    - i = 2 能被 perm[2] = 1 整除
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 15 
// 
//
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 394 👎 0

package leetcode.editor.cn;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：优美的排列
public class BeautifulArrangementXXX526 {
    public static void main(String[] args) {
        Solution solution = new BeautifulArrangementXXX526().new Solution();
// TO TEST
        boolean illegal = solution.illegal(Arrays.asList(1, 2, 3));
        System.out.println(illegal);
        int i = solution.countArrangement(4);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;
        List<Integer> track = new ArrayList<Integer>();

        List<Integer>[] match;

        public int countArrangement(int n) {
            // 先写一下排列的回溯 然后剪枝
            // 不出意料的超时了
            /*boolean used[] = new boolean[n+1];
            getPaiLie(n, used);*/
            // 优化一下剪枝 成功了
            /*boolean used[] = new boolean[n + 1];
            int res = getPaiLie1(n, 1, used);*/
            // 再来尝试一下使用动态规划
            // 假定dp[i]表示0-i构成优美排列的数量，那么只有dp[i]方程无法确定，不可行
            // 看n的范围只有15，估计可以用二进制来进行动规，但是规律有点麻烦。官方题解的动规看不懂
            // 我们再来用另一种方式处理一下回溯的剪枝，尽量不要超时
            boolean used[] = new boolean[n + 1];
            // 因为排列的时间复杂度是n的阶乘，所以提前用n^2时间复杂度处理好可行的排列结果，剪枝更快
            // match[i]表示i位置可以放的数字集合
            match = new ArrayList[n+1];
            for(int i =0;i<=n;i++){
                match[i] = new ArrayList<Integer>();
            }
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n;j++){
                    if(i%j==0 || j%i ==0){
                        match[i].add(j);
                    }
                }
            }
            getPaiLie2(n, 1,used);
            return res;

            // 至此，已经写了两种优化剪枝的回溯方法
            // 之后等位运算学会了 再学习一下动规
        }

        private void getPaiLie2(int n, int index, boolean[] used) {
            if (index > n) {
                res++;
                return;
            }
            for (int num : match[index]) {
                if (!used[num]) {
                    used[num] = true;
                    getPaiLie2(n, index + 1, used);
                    used[num] = false;
                }
            }
        }

        private int getPaiLie1(int n, int index, boolean used[]) {
            if (index > n) {
                return 1;
            }
            int res = 0;
            for (int num = 1; num <= n; num++) {
                if (used[num]) {
                    continue;
                }
                // 直接在进入递归之前进行判断
                if (num % index == 0 || index % num == 0) {
                    used[num] = true;
                    res += getPaiLie1(n, index + 1, used);
                    used[num] = false;
                }
            }
            return res;
        }

        private void getPaiLie(int n, boolean used[]) {
            if (!track.isEmpty() && illegal(track)) {
                return;
            }
            if (track.size() == n) {
                // 满足优美排列
                if (!illegal(track)) res++;
                return;
            }
            for (int i = 1; i <= n; i++) {
                if (used[i]) {
                    continue;
                }
                track.add(i);
                used[i] = true;
                getPaiLie(n, used);
                used[i] = false;
                track.remove(track.size() - 1);
            }
        }

        private boolean illegal(List<Integer> list) {
            // 注意别用findAny的isPresent，因为findAny产生的是一个数组流，即使流中全部是false，只要流不为空，isPresent都返回为true
            return list.stream().anyMatch(o -> isNotPerfect(list.indexOf(o) + 1, o));
            /*for(Integer o:list){
                if(isNotPerfect(list.indexOf(o)+1,o)){
                    return true;
                }
            }
            return false;*/
        }

        private boolean isNotPerfect(int index, int num) {
            return num % index != 0 && index % num != 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}