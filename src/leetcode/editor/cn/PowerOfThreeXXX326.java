//给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3ˣ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 27
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 9
//输出：true
// 
//
// 示例 4： 
//
// 
//输入：n = 45
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不使用循环或者递归来完成本题吗？ 
//
// Related Topics 递归 数学 👍 328 👎 0

package leetcode.editor.cn;

//Java：3 的幂
public class PowerOfThreeXXX326 {
    public static void main(String[] args) {
        Solution solution = new PowerOfThreeXXX326().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfThree(int n) {
            // 没啥意思的题，要不就暴力循环试除 要不就找到题目范围内最大的3的幂，看n是不是该数约数
            //3的19次方=1162261467
            return n > 0 && 1162261467 % n == 0;

        }

       /* static Set<Integer> set = new HashSet<>();

        // 还有一种类似前缀和的方式，初始化出所有的3的幂，每次判断set中是否包含n。
        static {
            int cur = 1;
            set.add(cur);
            while (cur <= Integer.MAX_VALUE / 3) {
                cur *= 3;
                set.add(cur);
            }
        }
        public boolean isPowerOfThree(int n) { return n > 0 && set.contains(n); }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}