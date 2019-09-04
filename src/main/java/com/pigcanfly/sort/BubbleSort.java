package com.pigcanfly.sort;

/**
 * 这个算法的名字由来是因为越大的元素会经由交换慢慢“浮”到数列的顶端（升序或降序排列），
 * 就如同碳酸饮料中二氧化碳的气泡最终会上浮到顶端一样，故名“冒泡排序”
 * 算法实现逻辑：
 * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2. 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 3. 针对所有的元素重复以上的步骤，除了最后一个。
 * 4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * @author tobbyquinn
 * @date 2019/09/04
 */
public class BubbleSort {
    public static int[] sort(int args[]) {
        if (args.length < 2) {
            return args;
        }
        for (int i = args.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                //swap
                if (args[j] > args[j + 1]) {
                    int tmp = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = tmp;
                }
            }
        }
        return args;
    }
}
