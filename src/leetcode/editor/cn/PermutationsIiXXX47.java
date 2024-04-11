//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1384 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：全排列 II
public class PermutationsIiXXX47{
public static void main(String[] args) {
Solution solution = new PermutationsIiXXX47().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        // 先排序，为后续去重奠定基础
        Arrays.sort(nums);
        boolean used[] = new boolean[nums.length];
        traverse(nums,used,new ArrayList<>());
        return res;
    }

    private void traverse(int[] nums,boolean[] used,List<Integer> track){
        if(track.size() == nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i =0;i<nums.length;i++){
            if(used[i]) continue;
            // 在这里加一行判断是否有重复的数据 去重的逻辑一定是used[i-1]为false。
            // 这样当出现了 1 1' 1'' 三个相同的数字的时候，可以保证他们的顺序，只有在前面的数字选了以后才可以选后面的
            // 就可以避免出现 1' 1'' 1 和1 1' 1''这样类似的重复结果

            // 其实这里写成used[i-1]而不是!used[i-1]，也是可以的，但是剪枝效果低了 画图可看得出来
            if(i>0 && !used[i-1] && nums[i] == nums[i-1]){
                continue;
            }
            used[i] = true;
            track.add(nums[i]);
            traverse(nums,used,track);
            used[i] = false;
            track.remove(track.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}