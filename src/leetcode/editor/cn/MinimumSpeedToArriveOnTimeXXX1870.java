//给你一个浮点数 hour ，表示你到达办公室可用的总通勤时间。要到达办公室，你必须按给定次序乘坐 n 趟列车。另给你一个长度为 n 的整数数组 dist ，
//其中 dist[i] 表示第 i 趟列车的行驶距离（单位是千米）。 
//
// 每趟列车均只能在整点发车，所以你可能需要在两趟列车之间等待一段时间。 
//
// 
// 例如，第 1 趟列车需要 1.5 小时，那你必须再等待 0.5 小时，搭乘在第 2 小时发车的第 2 趟列车。 
// 
//
// 返回能满足你准时到达办公室所要求全部列车的 最小正整数 时速（单位：千米每小时），如果无法准时到达，则返回 -1 。 
//
// 生成的测试用例保证答案不超过 10⁷ ，且 hour 的 小数点后最多存在两位数字 。 
//
// 
//
// 示例 1： 
//
// 
//输入：dist = [1,3,2], hour = 6
//输出：1
//解释：速度为 1 时：
//- 第 1 趟列车运行需要 1/1 = 1 小时。
//- 由于是在整数时间到达，可以立即换乘在第 1 小时发车的列车。第 2 趟列车运行需要 3/1 = 3 小时。
//- 由于是在整数时间到达，可以立即换乘在第 4 小时发车的列车。第 3 趟列车运行需要 2/1 = 2 小时。
//- 你将会恰好在第 6 小时到达。
// 
//
// 示例 2： 
//
// 
//输入：dist = [1,3,2], hour = 2.7
//输出：3
//解释：速度为 3 时：
//- 第 1 趟列车运行需要 1/3 = 0.33333 小时。
//- 由于不是在整数时间到达，故需要等待至第 1 小时才能搭乘列车。第 2 趟列车运行需要 3/3 = 1 小时。
//- 由于是在整数时间到达，可以立即换乘在第 2 小时发车的列车。第 3 趟列车运行需要 2/3 = 0.66667 小时。
//- 你将会在第 2.66667 小时到达。 
//
// 示例 3： 
//
// 
//输入：dist = [1,3,2], hour = 1.9
//输出：-1
//解释：不可能准时到达，因为第 3 趟列车最早是在第 2 小时发车。 
//
// 
//
// 提示： 
//
// 
// n == dist.length 
// 1 <= n <= 10⁵ 
// 1 <= dist[i] <= 10⁵ 
// 1 <= hour <= 10⁹ 
// hours 中，小数点后最多存在两位数字 
// 
//
// Related Topics 数组 二分查找 👍 62 👎 0

package leetcode.editor.cn;

//Java：准时到达的列车最小时速
public class MinimumSpeedToArriveOnTimeXXX1870{
public static void main(String[] args) {
Solution solution = new MinimumSpeedToArriveOnTimeXXX1870().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        // speed越大，通勤时间越短，所以x为speed，f(x)为通勤时间，此为单调减函数
        // 求最小时速，也就是左边界
        // speed最小的情况为中间没有任何停留，sum(dist)/hour speed最大的情况就是最大距离/1，这样hour最少为n
        if(Math.ceil(hour) < dist.length) return -1;

        // 最大值不是距离的最大值，最小值也不是sum/hour，因为hour可能是小数
//        long sum = Arrays.stream(dist).sum();
//        int max = Arrays.stream(dist).max().getAsInt();
//        double left = (sum+hour-1)/hour,right =max;

        // 这道题比较尴尬，就是在int 和double之间相互转换的时候，需要考虑如何处理才能保证不溢出，
        // 还有上文所说的left和right取基础值的时候的考虑
        int left =1, right = 10000000;
        while(left < right){
            int mid = (right-left)/2+left;
            double h = getTime(dist,mid);
            if(h>hour){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return  left;
    }

    private  double getTime(int []dist,int speed){
        double time =0;
        for(int i=0;i<dist.length-1;i++){
            // 备注：这种公式只适用于int型
            time += (dist[i]+speed-1)/speed;
        }
        // 到最后一个再转换为double
        time += (double) dist[dist.length - 1] / speed;
        return time;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}