//给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。 
//
// 请你返回排序后的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,2,2,2,3]
//输出：[3,1,1,2,2,2]
//解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,3,1,3,2]
//输出：[1,3,3,2,2]
//解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
// 
//
// 示例 3： 
//
// 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
//输出：[5,-1,4,4,-6,-6,1,1,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 数组 哈希表 排序 👍 167 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：按照频率将数组升序排序
public class SortArrayByIncreasingFrequencyXXX1636{
public static void main(String[] args) {
Solution solution = new SortArrayByIncreasingFrequencyXXX1636().new Solution();
// TO TEST
    int [] nums = new int[]{-1,1,-6,4,5,-6,1,4,1};
    int[] ints = solution.frequencySort(nums);
    System.out.println(ints.length);
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] frequencySort(int[] nums) {
        /*int f[] = new int[201];
        List<Integer> list = new ArrayList<>();
        // 方法1。由于数组中的值大小有限，所以可以直接使用定长数组进行每个数字出现的频率存储
        for(int item:nums){
            f[item+100]++;
            list.add(item);
        }
        // 使用Collections的排序方法
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(f[o1+100] != f[o2+100]){
                    // 按频率升序
                    return f[o1+100] - f[o2+100];
                }else{
                    // 降序
                    return o2-o1;
                }
            }
        });
        for(int i = 0;i<list.size();i++){
            nums[i] = list.get(i);
        }
        return nums;*/
        // 方法2 直接使用HashMap进行频率的存储
        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        for(int item:nums){
            map.put(item,map.getOrDefault(item,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int item:nums){
            list.add(item);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.get(o1)!= map.get(o2)){
                    // 按频率升序
                    return map.get(o1) - map.get(o2);
                }else{
                    // 降序
                    return o2-o1;
                }
            }
        });
        for(int i = 0;i<list.size();i++){
            nums[i] = list.get(i);
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}