//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 411 👎 0

package leetcode.editor.cn;
//Java：翻转对
public class ReversePairsXXX493{
public static void main(String[] args) {
Solution solution = new ReversePairsXXX493().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        if(null == nums || nums.length ==0) return 0;
        int len =nums.length;
        int[] temp = new int[len+1];
        for(int i =0;i<len;i++){
            temp[i] = nums[i];
        }
        deal(nums,0,len-1,temp);
        // todo
        return count;
    }
    public void deal(int[] nums,int l,int r,int[] temp){
        if(l<r) return;
        int mid = (r-l)/2+l;
        deal(nums,l,mid,temp);
        deal(nums,mid+1,r,temp);

        merge(nums,l,mid,r,temp);
    }

    public void merge(int[] nums,int l,int mid,int r,int[] temp){
        int i =l,j = mid+1;
        for(int k =l;k<=r;k++){
            if(i==mid+1){
                nums[k]=temp[i++];
            }else if(j==r+1){
                nums[k]=temp[j++];
            }else if(temp[i]<=temp[j]){
                nums[k]=temp[i++];
            }else{
                nums[k]=temp[j++];
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}