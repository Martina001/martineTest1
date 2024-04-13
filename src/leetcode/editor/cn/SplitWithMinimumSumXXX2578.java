package leetcode.editor.cn;

//给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足： 
//
// 
// num1 和 num2 直接连起来，得到 num 各数位的一个排列。 
// 
//
// 
// 换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。 
// 
// 
// num1 和 num2 可以包含前导 0 。 
//
//
// 请你返回 num1 和 num2 可以得到的和的 最小 值。 
//
// 注意： 
//
// 
// num 保证没有前导 0 。 
// num1 和 num2 中数位顺序可以与 num 中数位顺序不同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 4325
//输出：59
//解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
// 
//
// 示例 2： 
//
// 
//输入：num = 687
//输出：75
//解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
// 
//
// 
//
// 提示： 
//
// 
// 10 <= num <= 10⁹ 
// 
//
// Related Topics 贪心 数学 排序 👍 89 👎 0

import java.util.Arrays;
import java.util.LinkedList;

public class SplitWithMinimumSumXXX2578{
    public static void main(String[] args) {
        Solution solution = new SplitWithMinimumSumXXX2578().new Solution();
        int i = solution.splitNum(4325);
        System.out.println(i);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitNum(int num) {
        // 其实不用自己处理
        char list[] = Integer.toString(num).toCharArray();
        Arrays.sort(list);
        int[] a = new int[2];
        for(int i= 0;i<list.length;i++){
            a[i%2] =a[i%2]*10+list[i]-'0';
        }
        return a[0]+a[1];
       /* LinkedList<Integer> list = new LinkedList<>();
        while(num!=0){
            list.addLast(num%10);
            num /= 10;
        }
        Collections.sort(list);

        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();

        for(int i= 0;i<list.size();i++){
            if((i&1)==0){
                a.addLast(list.get(i));
            }else{
                b.addLast(list.get(i));
            }
        }
        int res = 0;
        String aa = getString(a);
        String bb = getString(b);
        res = Integer.valueOf(aa)+Integer.valueOf(bb);
        return res;*/
    }
    public String getString(LinkedList<Integer> v) {
        StringBuffer res = new StringBuffer();
        for (Integer s : v) {
            res.append(s);
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}