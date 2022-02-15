package com.jimmy.android.datastructurestudy.sort;

import org.junit.Test;

/**
 * @Description: 选择序列中的某个元素，将序列一分为2，小于该元素的放在前面，大于该元素的放在后面，相等的随便前后。那么这个元素就是 轴点元素(pivot)
 * <p>
 * 快速排序的流程：
 * <p>
 * 选择一个元素作为pivot。
 * 用pivot将序列一分为2。
 * 重复1~2直到不能再分割，即子序列元素个数为1（也可以认为此时的子序列中的元素也是自己的pivot）。
 * @Author: zhangchun
 * @CreateDate: 2022/2/14
 * @Version: 1.0
 */
public class QuickSort {
    @Test
    public void testQuickSort() {
        int[] array=new int[]{6,11,8,2,9,4,1,5,7,10,3};
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println("");
        quickSort(array,0,array.length-1);
        for (int i : array) {
            System.out.print(i+" ");
        }

    }

    /**
     * 如果轴点元素是取第一个，那么从数组的最后一位取值，找到第一个比轴点元素小的元素，将高指针位置的元素放在低指针的位置；low指针++
     * 从低指针位置开始找一个比轴点元素大的元素，将低指针位置上的元素放在高指针的位置；high指针++
     * 重复上面两个操作直到高低指针位置重合，则将轴点元素放在该位置，自此第一轮比较结束
     * 重复上面三个步骤，直至数据排序完成
     * <p>
     * 作者：往事一块六毛八
     * 链接：https://juejin.cn/post/6942837625493389319
     * 来源：稀土掘金
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param array
     */
    public void quickSort(int[] array, int begin, int end) {
        if (end - begin <= 0) return;

        int x = array[begin];
        int low = begin;
        int high = end;

        boolean direction = true;
        L1:
        while (low < high) {
            if (direction) {//从右边往左找
                for (int i = high; i > low; i--) {
                    if (array[i] <= x) {
                        array[low++] = array[i];
                        high = i;
                        direction = !direction;
                        continue L1;
                    }
                }
                high = low;//如果上面的if从未进入，让两个指针重合
            } else {
                for (int i = low; i < high; i++) {
                    if (array[i] >= x) {
                        array[high--] = array[i];
                        low = i;
                        direction = !direction;
                        continue L1;
                    }
                }
                low = high;//如果上面的if从未进入，让两个指针重合
            }
        }

        //把最后找到的值 放入中间位置
        array[low] = x;
        //开始完成左右两边的操作
        quickSort(array, begin, low - 1);
        quickSort(array, low + 1, end);

    }
}
