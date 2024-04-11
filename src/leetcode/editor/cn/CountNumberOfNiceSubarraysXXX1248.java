//给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。 
//
// 请返回这个数组中 「优美子数组」 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2,1,1], k = 3
//输出：2
//解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,4,6], k = 1
//输出：0
//解释：数列中不包含任何奇数，所以不存在优美子数组。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//输出：16
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10^5 
// 1 <= k <= nums.length 
// 
//
// Related Topics 数组 哈希表 数学 滑动窗口 👍 292 👎 0

package leetcode.editor.cn;

//Java：统计「优美子数组」
public class CountNumberOfNiceSubarraysXXX1248 {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfNiceSubarraysXXX1248().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            // 这道题很直接可以用一下滑动窗口 不像560题 和为K的子数组 那道题是求和 考虑到有负数 所以不适合用滑动窗口
            // 因为滑动窗口有一点小坑 就是要计算子数组边上偶数的个数  所以我们再来看看怎么用前缀和的方式求解
            // 前缀和的方式跟560有点像，不过看起来更简单点 前缀和不再是数值和 而是截止到当前奇数个数和
            // 有了前缀和 双重循环统计 pre[j]-pre[i]=k的个数 不过这样嵌套循环会超时
            // 跟第一题（两数之和）和560题一样，采用hashMap来进行优化 这里我们直接使用前缀和数组来充当hashMap
            // pre[i]=j 其中i是当前奇数个数 也就前缀和（map中的key） j是前缀和的个数 也就是截止到当前奇数个数为i的总计次数（map中的value）
            int n = nums.length;
            int pre[] = new int[n+1];
            // 注意 奇数个数为0出现的次数为1
            pre[0]= 1;
            int res = 0,sum =0;
            for(int num:nums){
                sum+=num&1;
                pre[sum] ++;
                if(sum >=k){
                    res += pre[sum-k];
                }
            }
            return res;
            /*int n = nums.length;
            int left = 0, right = 0;
            int count = 0;
            int res = 0;
            while (right < n) {
                int num = nums[right];
                right++;
                if (num % 2 == 1) {
                    count++;
                }

                if (count == k) {
                    // 注意这里别忘了还需要统计当前最后一个奇数之后的偶数个数 和第一个奇数之前的偶数个数相乘才是最终结果 不要只是单纯++
                    int r = right;
                    while (right < n && (nums[right] & 1) == 0) {
                        // 窗口增大的同时 记录偶数个数
                        right++;
                    }
                    int rightEvenCnt = right-r;
                    int leftEvenCnt = 0;
                    while (left <  r && nums[left] % 2 != 1) {
                        left++;
                        leftEvenCnt++;
                    }

                    // 左边可以偶数全都不要，有leftEvenCnt+1种选择 右边同理
                    res += (leftEvenCnt+1)*(rightEvenCnt+1);
                    count--;
                    // 这里记得 left继续加 窗口缩小
                    left++;
                }
            }
            return res;*/
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}