package cn.iocoder.springboot.labs.lab09.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSorterTest {

    public static void main(String[] args) {
        {
            int[] array = new int[]{5, 4, 2, 3, 1, 2, 5, 2, 6};
//            int[] array = new int[]{6, 11, 8};
            quickSort(array);
        }
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        // 寻找 partition 位置
        int partitionIndex = partition(array, low, high);

        // 递归排序
        quickSort(array, low, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, high);
    }

    @SuppressWarnings("Duplicates")
    public static int partition(int[] array, int low, int high) {
        int partitionValue = array[high]; // 首先，选择 high 位置的值，作为 partitionValue 值
        int pos = low;
        // 遍历 array 的 low 到 high 区间，将小于 partitionValue 值的部分，顺序放到 [0, pos) 范围内。最终，pos 我们会放 partitionValue 值。
        for (int i = low; i < high; i++) {
            if (array[i] < partitionValue) {
                // 进行交换
                swap(array, i, pos);
                // pos + 1 ，用于下一个使用
                pos++;
            }
        }

        // 将 pos 我们会放 partitionValue 值。
        swap(array, pos, high);

        // 返回 partitionValue 所在位置
        return pos;
    }

    private static void swap(int[] array, int pos1, int pos2) {
        if (pos1 == pos2) {
            return;
        }
        int tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;
    }

}
