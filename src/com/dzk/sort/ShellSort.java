package com.dzk.sort;

/**
 * 希尔排序
 * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1。希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1。
 *
 * 希尔排序使用插入排序对间隔 h 的序列进行排序。通过不断减小 h，最后令 h=1，就可以使得整个数组是有序的
 */
public class ShellSort extends BaseSort{
    public static void main(String[] args) {
        int[] input = {3,2,4,1,6,-1};
        doSort(input);
        printArray(input);

    }

    private static void doSort(int[] input) {
        if (input == null || input.length < 2){
            return;
        }

        int length = input.length;
        int h = 1;//交换间隔
        while (h < length / 3){
            h = 3 * h + 1;
        }

        while (h >= 1){
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h ; j-=h) {
                    if (input[j] < input[j -h]){
                        swap(input,j,j-h);
                    }
                }
            }

            h /= 3;
        }

    }
}
