//整数的 数组形式 num 是按照从左到右的顺序表示其数字的数组。 
//
// 
// 例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。 
// 
//
// 给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：num = [1,2,0,0], k = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
// 
//
// 示例 2： 
//
// 
//输入：num = [2,7,4], k = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
// 
//
// 示例 3： 
//
// 
//输入：num = [2,1,5], k = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 10⁴ 
// 0 <= num[i] <= 9 
// num 不包含任何前导零，除了零本身 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 数组 数学 👍 247 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：数组形式的整数加法
public class AddToArrayFormOfIntegerXXX989 {
    public static void main(String[] args) {
        Solution solution = new AddToArrayFormOfIntegerXXX989().new Solution();
// TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> addToArrayForm(int[] num, int k) {
            int n = num.length;
            int carry = 0;
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = n - 1; i >= 0; i--) {
                int val = num[i];
                int newVal = val + k % 10 + carry;
                linkedList.addFirst(newVal % 10);
                // num[i] = newVal % 10;
                k /= 10;
                carry = newVal / 10;
            }
            if(carry !=0 || k !=0){
                int val = carry+k;
                while(val !=0){
                    linkedList.addFirst(val%10);
                    val = val/10;
                }
            }
            /*List<Integer> list = new ArrayList<>();
            if(carry != 0){
                list.add(carry);
            }
            for(int val:num){
                list.add(val);
            }*/
            return linkedList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}