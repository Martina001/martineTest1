package lc;

/**
 * @author: Martina
 * @description: 归并排序
 * @time: 2023/10/31
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4,4, 2, 9, 6, 23, 12, 34, 0, 1};
//        int[] arr = {3, 3, 4, 5, 3};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(String.valueOf(arr));
    }

    private static void mergeSort(int nums[], int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        merge(nums, l, mid, r);
    }

    private static void merge(int nums[], int l, int mid, int r) {
        int temp[] = new int[r - l + 1];
        int i = l, j = mid + 1;
        int index = 0;
        // 注意是两端都闭的区间
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) temp[index++] = nums[i++];
            else temp[index++] = nums[j++];
        }
        while (i <= mid) temp[index++] = nums[i++];
        while (j <= r) temp[index++] = nums[j++];

        // 回归到原数组
        for (int k = 0; k < temp.length; k++) {
            nums[k + l] = temp[k];
        }
    }
}

