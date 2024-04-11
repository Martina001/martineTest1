//几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第 k 小的数字吗？ 
//
// 乘法表是大小为 m x n 的一个整数矩阵，其中 mat[i][j] == i * j（下标从 1 开始）。 
//
// 给你三个整数 m、n 和 k，请你在大小为 m x n 的乘法表中，找出并返回第 k 小的数字。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：m = 3, n = 3, k = 5
//输出：3
//解释：第 5 小的数字是 3 。
// 
//
// 示例 2： 
// 
// 
//输入：m = 2, n = 3, k = 6
//输出：6
//解释：第 6 小的数字是 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 3 * 10⁴ 
// 1 <= k <= m * n 
// 
//
// Related Topics 数学 二分查找 👍 358 👎 0

package leetcode.editor.cn;

//Java：乘法表中第k小的数
public class KthSmallestNumberInMultiplicationTableXXX668 {
    public static void main(String[] args) {
        Solution solution = new KthSmallestNumberInMultiplicationTableXXX668().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthNumber(int m, int n, int k) {
            // 这道题乍一看总觉得应该先把二维数组变成一维，然后类似215题找数组中的第k大元素 但是m和n都巨大，所以快速选择算法也不会很高
            // 好在这个数组是有规律的，所以我们可以采用二分法 重点在于分什么。
            // 因为数组中的元素都是两数乘积 所以我们可找到一个乘积值，这个值正好是第k小的乘积。设此乘积值为x，函数就是f(x),表示此时比x小的元素个数，用f(x)和k比较就行
            // 注意点：f(x)怎么算比较好
            int left = 1, right = m * n;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                int cnt = f(mid, m, n);
                if (cnt >= k) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 返回left和right都可
            return left;
        }

        /**
         * 在乘法表中找到不比val大的元素个数
         * 直接画图 简单点，找val所在对角线分割后的上半部分的个数
         *
         * @param val
         * @param m
         * @param n
         * @return
         */
        private int f(int val, int m, int n) {
            // m为行 n为列
            // 从左往右 每次计算当前列满足要求的个数，将其加进来
            int res = 0;
            // 注意i可以取n 这种就别再写错了好吧
            for (int i = 1; i <= n; i++) {
                // 如果当前列的最大值不大于val，这一列的个数都加进来
                if (i * m <= val) res += m;
                else {
                    // 找到当前列中小于val的个数 也就是val处于第几行，也就是val/当前列
                    res += val / i;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}