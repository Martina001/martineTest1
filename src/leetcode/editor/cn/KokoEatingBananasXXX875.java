//珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。 
//
// 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉。 
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。 
//
// 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：piles = [3,6,7,11], h = 8
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：piles = [30,11,23,4,20], h = 5
//输出：30
// 
//
// 示例 3： 
//
// 
//输入：piles = [30,11,23,4,20], h = 6
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 10⁴ 
// piles.length <= h <= 10⁹ 
// 1 <= piles[i] <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 594 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：爱吃香蕉的珂珂
public class KokoEatingBananasXXX875 {
    public static void main(String[] args) {
        Solution solution = new KokoEatingBananasXXX875().new Solution();
// TO TEST
        int[] a = new int[]{2, 4};
        System.out.println(solution.getHour(a, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            // 最小速度可以为1，最大速度也就是piles中的最大值
            int maxK = Arrays.stream(piles).max().getAsInt();
            // 第一次left设置为1的时候 超时了，本来以为是left可以更大，后来发现是getHour的写法不对
            // 另，注意二分搜索法一般都是左闭右开，循环结束必然是left=right
            int left = 1, right = maxK;
            // 左闭右开 left不能等于right 不然就死循环了
            while (left < right) {
                int mid = (right - left) / 2 + left;
                int hour = getHour(piles, mid);
                if (hour > h) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        private int getHour(int nums[], int speed) {
            int sum = 0;
            for (int num : nums) {
                // 注意：上取整可以这样写
                sum += (num + speed - 1) / speed;
            }
            return sum;
        /*
        // 这个写法会超时 因为还嵌套了个循环
        int h = 0;
        for(int num:nums){
            if(num<=speed){
                h++;
            }else{
                while (num>0){
                    h++;
                    num-=speed;
                }
            }
        }
        return h;*/
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}