//给你两个 正整数 数组 arr1 和 arr2 。 
//
// 正整数的 前缀 是其 最左边 的一位或多位数字组成的整数。例如，123 是整数 12345 的前缀，而 234 不是 。 
//
// 设若整数 c 是整数 a 和 b 的 公共前缀 ，那么 c 需要同时是 a 和 b 的前缀。例如，5655359 和 56554 有公共前缀 565 ，而
// 1223 和 43456 没有 公共前缀。 
//
// 你需要找出属于 arr1 的整数 x 和属于 arr2 的整数 y 组成的所有数对 (x, y) 之中最长的公共前缀的长度。 
//
// 返回所有数对之中最长公共前缀的长度。如果它们之间不存在公共前缀，则返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr1 = [1,10,100], arr2 = [1000]
//输出：3
//解释：存在 3 个数对 (arr1[i], arr2[j]) ：
//- (1, 1000) 的最长公共前缀是 1 。
//- (10, 1000) 的最长公共前缀是 10 。
//- (100, 1000) 的最长公共前缀是 100 。
//最长的公共前缀是 100 ，长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：arr1 = [1,2,3], arr2 = [4,4,4]
//输出：0
//解释：任何数对 (arr1[i], arr2[j]) 之中都不存在公共前缀，因此返回 0 。
//请注意，同一个数组内元素之间的公共前缀不在考虑范围内。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 5 * 10⁴ 
// 1 <= arr1[i], arr2[i] <= 10⁸ 
// 
//
// Related Topics 字典树 数组 哈希表 字符串 👍 5 👎 0

package leetcode.editor.cn;

import java.util.HashSet;

//Java：最长公共前缀的长度
public class FindTheLengthOfTheLongestCommonPrefixXXX3043 {
    public static void main(String[] args) {
        Solution solution = new FindTheLengthOfTheLongestCommonPrefixXXX3043().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonPrefix(int[] arr1, int[] arr2) {
            // 题目给出的值都在Integer的取值范围内，所以可以用String处理，也可以直接用int数值处理
            // String处理就是比较subString，暴力
            // int处理就是不断/10，保存两个arr中所有的前缀，取最大值即可


            // 先写String类型
            /*HashSet<String> set = new HashSet<>();
            for (int x : arr1) {
                String s = String.valueOf(x);
                for (int i = 0; i <= s.length(); i++) {
                    // 注意左闭右开，所以i可以等于len
                    set.add(s.substring(0, i));
                }
            }

            int res = 0;
            for (int x : arr2) {
                String s = String.valueOf(x);
                for (int i = 0; i <= s.length(); i++) {
                    if (set.contains(s.substring(0, i))) {
                        res = Math.max(res, i);
                    }
                }
            }
            return res;
            */
            // 再写int类型
            HashSet<Integer> set = new HashSet<>();
            for (int x : arr1) {
                while (x > 0) {
                    set.add(x);
                    x = x / 10;
                }
            }

            int res = 0;
            for (int x : arr2) {
                while (x > 0) {
                    if (set.contains(x)) {
                        res = Math.max(res, x);
                    }
                    x = x / 10;
                }
            }
            return res == 0 ? 0 : String.valueOf(res).length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}