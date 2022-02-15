package com.jimmy.android.datastructurestudy.sort;

import org.junit.Test;

/**
 * @Description: 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始（队尾）位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾（队首）。以此类推，直到所有元素均排序完毕
 * <p>
 * 操作步骤：
 * <p>
 * 以第一个元素为基准，下标index先固定在第一个元素下，
 * 从index+1后面的元素循环依次跟index下标元素比较，如果找到比第一个元素小的，则下标index跑到这个小的数下面，直到第一轮结束找到数组中最小的元素标固定在最小元素的位置
 * 取排好序的队列队尾元素跟当前index下标的数据比较，如果队尾位置上的元素比当前index小则呼唤，直至队列排好序。
 * <p>
 * 作者：往事一块六毛八
 * 链接：https://juejin.cn/post/6942377450806476807
 * 来源：稀土掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Author: zhangchun
 * @CreateDate: 2022/2/13
 * @Version: 1.0
 */
public class SelectSort {

    @Test
    public void selectSortTest() {

        int[] array = new int[]{3,2,5,8,1,9,4,6,7};
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        selectSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }

    }

    public void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }

            if (index != i) { //则跟第i个位置交换
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }

        }

    }
}
