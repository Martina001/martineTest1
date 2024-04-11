//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2312 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：和为 K 的子数组
public class SubarraySumEqualsKXXX560{
public static void main(String[] args) {
Solution solution = new SubarraySumEqualsKXXX560().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        // 先说一下暴力解法 直接n^2的复杂度 嵌套循环即可
        // 滑动窗口失败了 题目提示是前缀和 怎么用前缀和呢
        // 看了题解，来简单解释一下，只要存在某个前缀和prePre = 当前前缀和pre -k 就说明结果++
        // 本来自己想的是前缀和数组内外两层循环(嵌套循环的解法需要自己写一下)，这里用一些hashMap 空间换时间,直接定位到是否之前存在pre
        // map的key为前缀和，value为出现次数
        // 注意点是 初始化map的时候 要先初始化一个（0，1）以防漏掉那些符合要求的子数组结果左侧和为0的数组（下面自己写的滑动窗口就犯了这个错误）

        // 类似题目 1248 统计优美子数组  先去看1248更容易理解这道题
        int n = nums.length;
        HashMap<Integer,Integer> preSumFrequency = new HashMap<>(n);
        //初始化别忘了
        preSumFrequency.put(0,1);
        int res = 0;
//        int pre[] =new int[n];
        int pre = 0;// 扁平化前缀和 因为有hashMap了 所以不用使用前缀和数组了
        for(int i=0;i<n;i++){
            pre += nums[i];
            if(preSumFrequency.containsKey(pre-k)){
                res += preSumFrequency.get(pre-k);
            }
            preSumFrequency.put(pre, preSumFrequency.getOrDefault(pre,0)+1);
        }
        return res;
    }


    private int test(int[] nums,int k){
        // 滑动窗口？ 试一下
        int n = nums.length;
        int right =0,left =0;
        int sum = 0;
        int res =0;
        while(right<n){
            sum+=nums[right];
            right++;
            // 这样不行（只对正数数组有效） 因为如果符合要求的子数组结果的左侧，和为0连续子数组会被忽略，其实左侧部分也应该并入结果集
            while(sum >= k && left <right)
            {
                if(sum == k){
                    res++;
                }
                sum-= nums[left];
                left++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}