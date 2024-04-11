//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3800 👎 0

package leetcode.editor.cn;
//Java：整数反转
public class ReverseIntegerXXX7{
public static void main(String[] args) {
Solution solution = new ReverseIntegerXXX7().new Solution();
// TO TEST
    System.out.println(Integer.MAX_VALUE +","+Integer.MIN_VALUE);
    int res = solution.reverse(-123);
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        // 题目要求是本机环境无法保存64位整数 也就不能用long
        /*boolean mark = true;
        if(x<0) {
            mark =false;
            x=-x;
        }
        Long tail = 0L;
        while(x>0){
            tail = tail*10+ x%10;
            x = x/10;
        }
        long rs = mark ? tail : -tail;
        if(rs<Integer.MIN_VALUE || rs>Integer.MAX_VALUE) rs = 0L;
        return (int) rs;*/

        // 在循环时候就判断是否溢出，溢出的条件需要仔细看一下
        // 这里可以记一下 int的最值：-2147483648 <= int <= 2147483647 也可以自己手算 2的32次方
        // -2 31次方 <= int <= 2 31次方-1
        int tail= 0;
        // 循环结束条件是x!=0 不是x>0 考虑负数
        while(x != 0){
            int temp = x%10;
            // 注意 算到最值/10的时候就要开始判断是不是会溢出了
            if(tail > 214748364 || (tail == 214748364 && temp>7)
                    || tail < -214748364 || (tail == -214748364 && temp<-8)) return 0;
            tail =tail*10 + temp;
            x = x/10;
        }
        return tail;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}