//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= 
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁴ 
// 0 <= t <= 2³¹ - 1 
// 
//
// Related Topics 数组 桶排序 有序集合 排序 滑动窗口 👍 689 👎 0

package leetcode.editor.cn;

import java.util.TreeSet;

//Java：存在重复元素 III
public class ContainsDuplicateIiiXXX220{
public static void main(String[] args) {
Solution solution = new ContainsDuplicateIiiXXX220().new Solution();
// TO TEST
    boolean b = solution.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3);
    System.out.println(b);
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // 使用TreeSet，每次加进去都需要排序 复杂度为nlogn
        TreeSet<Integer> treeSet =new TreeSet<>();
        // 以下几个函数都返回对应的最接近值
//        treeSet.lower() <的最大值
//        treeSet.higher() >的最小值
//        treeSet.floor() <=的最大值
//        treeSet.ceiling() >=的最小值
        for(int i =0;i<nums.length;i++){
            // ceiling函数表示获取大于或者等于传入值的最小值
            Integer ceiling = treeSet.ceiling( nums[i]-valueDiff);
            // abs(x-y)<=t 就是y>=x-t && y<=x+t
            if(ceiling != null && ceiling<=valueDiff+nums[i]) return true;
            treeSet.add(nums[i]);
            if(i>=indexDiff){
                treeSet.remove(nums[i-indexDiff]);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}