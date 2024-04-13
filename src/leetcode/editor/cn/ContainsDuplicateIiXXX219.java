//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i 
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 587 👎 0

package leetcode.editor.cn;

import java.util.HashSet;

//Java：存在重复元素 II
public class ContainsDuplicateIiXXX219 {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIiXXX219().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer,Integer> map = new HashMap<>(nums.length);
            for(int i = 0;i<nums.length;i++){
                if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i])-i)<=k){
                    return true;
                }
                map.put(nums[i],i);
            }
            return false;
        }*/
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            // 控制一个长度为k的滑动窗口，如果窗口中已经有当前值就返回true。
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > k) {
                    set.remove(nums[i - k - 1]);
                }
                if (!set.add(nums[i])) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}