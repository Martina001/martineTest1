//给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 示例 2: 
//
// 
//输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
//输出：[22,28,8,6,17,44]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
//
// Related Topics 数组 哈希表 计数排序 排序 👍 288 👎 0

package leetcode.editor.cn;
//Java：数组的相对排序
public class RelativeSortArrayXXX1122{
public static void main(String[] args) {
Solution solution = new RelativeSortArrayXXX1122().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = -1;
        // 先取最大值，确定frequency数组的长度
        for(int item:arr1){
            max = Math.max(item,max);
        }
        int frequency[] =new int[max+1];
        for(int item:arr1){
            frequency[item]++;
        }
        int res[] = new int[arr1.length];
        int i=0;
        // 注意是while循环，不是if，因为有重复
        for(int item :arr2){
            while(frequency[item]>0){
                res[i++]=item;
                frequency[item]--;
            }
        }
        // 最后从小到达遍历，即可保证后面的数字是按序排列
        for(int j = 0;j<=max;j++){
            while(frequency[j]>0){
                res[i++]=j;
                frequency[j]--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}