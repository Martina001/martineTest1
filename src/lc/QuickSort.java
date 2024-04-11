package lc;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.Random;

/**
 * @author: Martina
 * @description:
 * @time: 2023/4/24
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {4, 2, 9, 6, 23, 12, 34, 0, 1};
        int[] arr = {3, 3, 4, 5, 3};
        Random random = new Random();
        for(int k=0;k<arr.length;k++){
            // random的nextInt左闭右开，生成0-参数之间的随机数
            int i = random.nextInt(arr.length-k);
            swap(arr,k,k+i);
        }
        sort(arr, 0, arr.length - 1);
        System.out.println(String.valueOf(arr));
    }

    private static void sort(int[] nums, int low, int high) {
        if (low >= high) return;
        int p = getPFromLowA(nums, low, high);
        sort(nums, low, p - 1);
        sort(nums, p + 1, high);
    }

    /**
     * 单向不断互换，简单易懂不容易有细节问题
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private static int getPFromLowA(int[] nums, int low, int high) {
        int p = nums[low];
        int temp = low;
        for (int i = low+1; i <= high; i++) {
            if (nums[i] < p) {
                temp++;
                swap(nums, temp, i);
            }
        }
        swap(nums, temp, low);
        return temp;
    }
    /**
     * 单向不断互换，简单易懂不容易有细节问题
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private static int getPFromHigh(int[] nums, int low, int high) {
        int p = nums[high];
        int temp = low;
        for (int i = low; i < high; i++) {
            if (nums[i] < p) {
                swap(nums, temp, i);
                temp++;
            }
        }
        swap(nums, temp, high);
        return temp;
    }

    private static int getPFromHigh2(int[] nums, int low, int high) {
        int p = nums[high];
        int temp = low-1;
        for (int i = low; i < high; i++) {
            if (nums[i] < p) {
                temp++;
                swap(nums, temp, i);
            }
        }
        swap(nums, temp+1, high);
        return temp+1;
    }


    /**
     * 细节点太多，不推荐
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private static int getPFromLow(int[] nums, int low, int high) {
        int p = nums[low];
        int i = low, j = high;
        while (i < j) {
            // 和低位互换要先从高位开始遍历，不然i指向的值就是较大值，和低位互换后较大值就变到低位了
            while (i < j && nums[j] > p) j--;
            // 因为是i要和低位互换，所以num[i]可以=p
            while (i < j && nums[i] <= p) i++;
            // 只要左指针还不等于右指针就交换后继续走
            if (i != j) swap(nums, i, j);
        }
        // 当i=j的时候就说明都遍历了一次了，交换即可
        swap(nums, low, i);
        return i;
    }

    private static void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
