//实现RandomizedSet 类： 
//
// 
// 
// 
// RandomizedSet() 初始化 RandomizedSet 对象 
// bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。 
// bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。 
// int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。 
// 
// 
// 
//
// 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。 
//
// 
//
// 示例： 
//
// 
//输入
//["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", 
//"insert", "getRandom"]
//[[], [1], [2], [2], [], [1], [2], []]
//输出
//[null, true, false, true, 2, true, false, 2]
//
//解释
//RandomizedSet randomizedSet = new RandomizedSet();
//randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
//randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
//randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
//randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
//randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
//randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
//randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// 最多调用 insert、remove 和 getRandom 函数 2 * 10⁵ 次 
// 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。 
// 
//
// Related Topics 设计 数组 哈希表 数学 随机化 👍 786 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：O(1) 时间插入、删除和获取随机元素
public class InsertDeleteGetrandomO1XXX380{
public static void main(String[] args) {
    RandomizedSet solution = new InsertDeleteGetrandomO1XXX380().new RandomizedSet();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class RandomizedSet {
    // 首先 数组一定是可以满足在O1时间内随机查询，但是无法直接插入和删除 所以这时候可以结合HashMap将每个值的索引进行存储，这样每次插入、查找都是O1
    // 删除比较特殊，可以先将目标值和数组末位值两个互换，更新HashMap中末位值的索引，然后将nums最后一位和HashMap中指定值都remove掉即可。

    List<Integer> nums;
    HashMap<Integer,Integer> valueOfIndexMap;
    Random random;
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        valueOfIndexMap = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(valueOfIndexMap.containsKey(val)){
            return false;
        }
        nums.add(val);
        valueOfIndexMap.put(val,nums.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!valueOfIndexMap.containsKey(val)){
            return false;
        }
        int targetIndex = valueOfIndexMap.get(val);
        valueOfIndexMap.put(nums.get(nums.size()-1),targetIndex);
        Collections.swap(nums,targetIndex,nums.size()-1);
        nums.remove(nums.size()-1);
        valueOfIndexMap.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}