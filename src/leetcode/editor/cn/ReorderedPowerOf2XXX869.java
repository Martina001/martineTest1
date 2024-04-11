//给定正整数 n ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。 
//
// 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 10
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 哈希表 数学 计数 枚举 排序 👍 176 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：重新排序得到 2 的幂
public class ReorderedPowerOf2XXX869 {
    public static void main(String[] args) {
        Solution solution = new ReorderedPowerOf2XXX869().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean reorderedPowerOf2(int n) {
            //  自己能想到的办法就是把n中的数字当成数组，进行全排列，去除前导的0后判断是否为2的幂，2的幂可以用n&(n-1)==0来判断
            // 看一下巧妙的解法 预处理+哈希表的操作
            // 原理就是 如果两个数字的0-9出现的次数一致，那么这俩数返回结果就一致。
            // 所以找到题目范围内的所有2的幂，并记录其对应的0-9的次数，判断n中对应次数是否一致就行
            init();
            return powerOf2Digits.contains(getDigitCount(n));
        }

        private String getDigitCount(int n) {
            // 用来记录 对应索引下标在n中出现的次数 cnt[i]=数字i在n中出现的次数
            char[] cnt = new char[10];
            while (n > 0) {
                cnt[n % 10]++;
                n = n / 10;
            }
            return new String(cnt);
        }

        Set<String> powerOf2Digits = new HashSet<String>();
        public void init() {
            // 每次左移1 就是乘2
            for (int n = 1; n <= 1e9; n <<= 1) {
                powerOf2Digits.add(getDigitCount(n));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}