//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 941 👎 0

package leetcode.editor.cn;

//Java：移掉 K 位数字
public class RemoveKDigitsXXX402 {
    public static void main(String[] args) {
        Solution solution = new RemoveKDigitsXXX402().new Solution();
// TO TEST
        /*String s = solution.removeKdigits("10001", 1);
        System.out.println(s);*/
//        System.out.println(trimZero("000"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            if (num.isEmpty() || k < 0) return num;
            if (num.length() == k) return "0";
            char[] chars = num.toCharArray();
            int count = 0;
            // 最终结果也可以用队列存储
            StringBuilder res = new StringBuilder(num.length() - k + 1);
            res.append(chars[0]);
            for (int i = 1; i < chars.length; i++) {
                while (res.length() > 0 && res.charAt(res.length() - 1) > chars[i] && count < k) {
                    res.deleteCharAt(res.length() - 1);
                    count++;
                }
                res.append(chars[i]);
            }
            String str = res.toString();
            if (count < k) {
                str = str.substring(0, str.length() - k + count);
            }
            str = trimZero(str);
            if (str.isEmpty() || str.equalsIgnoreCase("0")) return "0";
            return str;
        }
        private String trimZero(String str) {
            while (str.length() > 0) {
                if ((str.length() == 1 && str.charAt(0) == '0') || str.charAt(0) != '0') break;
                str = str.substring(1);
            }
            return str;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}