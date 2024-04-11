//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
//
// Related Topics 数组 动态规划 👍 1324 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三角形最小路径和
public class TriangleXXX120 {
    public static void main(String[] args) {
        Solution solution = new TriangleXXX120().new Solution();
// TO TEST
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(2);
        arr.add(a);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        arr.add(b);
        List<Integer> c = new ArrayList<>();
        c.add(6);
        c.add(5);
        c.add(7);
        arr.add(c);
        List<Integer> d = new ArrayList<>();
        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);
        arr.add(d);
        int i = solution.minimumTotal(arr);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            // 很明显 这是一个动归问题 类似于64最小路径和 直接dpIJ表示到索引标（i，j）时的最小路径
           /* int m = triangle.size();
            int n = triangle.get(m - 1).size();
            int dp[][] = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            dp[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < m; i++) {
                dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
//        注意是要找到最后一行 不是到最后一个角
            int res = dp[m - 1][0];
            for (int i = 1; i < n; i++) {
                res = Math.min(dp[m - 1][i], res);
            }
            return res;*/
//            return dpD(triangle);
            return dpD1(triangle);
        }

        private int dpD(List<List<Integer>> triangle) {
            // 试一下空间压缩
            int m = triangle.size();
            int n = triangle.get(m - 1).size();
            // dp[i]表示到某行的i列处的最小路径和，求最后一行的所有列的最小值
            int dp[] = new int[n];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = triangle.get(0).get(0);
            for (int i = 1; i < n; i++) {
                // 必须倒序 不然会被重复使用
//                换句话说，当走到j列位置的时候，需要用上一行的j列和j-1列的最值，如果正序处理，dp[j-1]已经是本行的j-1列的最值了
                for (int j = i; j >= 1; j--) {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                }
                // 这里一定要把0位置的加进来，因为j取不到0 还需要判断到首列位置时的最值
                dp[0] += triangle.get(i).get(0);
            }
            int res = dp[0];
            for (int i = 1; i < n; i++) {
                res = Math.min(res, dp[i]);
            }
            return res;
        }

        //        说明一下 这里如果换一个dp定义 会更好，从下往上倒着走，最终求得就是到顶端[0,0]位置的最值，简单快速
        private int dpD1(List<List<Integer>> triangle) {
            // 默认m和n 是相等的
            int n = triangle.size();
//            给一个空行，作为最后一行，避免dp[j+1]在j为n-1的时候溢出
            int dp[] = new int[n+1];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
                }
            }
            return dp[0];
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}