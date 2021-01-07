# **一、排序**

### 1.选择排序

从数组中选择最小元素，将它与数组的第一个元素交换位置。再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序。

![choose_insert](./image/choose_sort.gif)

```java
//快速排序
    private static void chooseSort(int[] input) {
        if (input == null || input.length < 2){
            return;
        }
        int length = input.length;
        int min = 0;
        for (int i = 0; i < length-1; i++) {
            min = i;
            //出错点:j从i+1开始，因为i之前的已经是有序的
            for (int j = i + 1; j < length; j++) {
                if (input[j] < input[min]){
                    min = j;
                }
            }
            if (min != i){
                swap(input,i,min);
            }
        }
    }
```



### 2.冒泡排序

从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。

在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。

![bubble_sort](./image/bubble_sort.gif)

```java
//冒泡排序
    private static void bubbleSort(int[] input) {
        if (input == null ||input.length < 2){
            return;
        }
        boolean isSorted = false;
        for (int i = 0; i < input.length-1; i++) {
            isSorted = false;
            for (int j = 0; j < input.length - 1 - i; j++) {
                if (input[j] > input[j+1]){
                    swap(input,j,j+1);
                    isSorted = true;
                }
            }

            if (!isSorted){
                System.out.println("没有一次交换,已经排好序");
                return;
            }
        }
    }
```



### 3.插入排序

每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序。

![insert_sort](./image/insert_sort.gif)

```java
private static void insertSort(int[] input) {
        if (input == null || input.length < 2){
            return;
        }

        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j-1] > input[j]){
                    swap(input,j-1,j);
                }else {
                    break;
                }
            }
        }
    }
```



### 4.希尔排序

对于数组 {3, 5, 2, 4, 1}，它具有以下逆序：(3, 2), (3, 1), (5, 2), (5, 4), (5, 1), (2, 1), (4, 1)，插入排序每次只能交换相邻元素，令逆序数量减少 1，因此插入排序需要交换的次数为逆序数量。

插入排序的时间复杂度取决于数组的初始顺序，如果数组已经部分有序了，那么逆序较少，需要的交换次数也就较少，时间复杂度较低。

间隔的序列是按照1,4,13,40,....来进行的，所以h =  h * 3 + 1;

希尔排序的运行时间达不到平方级别，使用递增序列 1, 4, 13, 40, ... 的希尔排序所需要的比较次数不会超过 N 的若干倍乘于递增序列(1,4,13,40,...)的长度。

![shell_sort](./image/shell_sort.png)

```java
private static void shellSort(int[] input) {
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
```

### 5.归并排序

归并排序的思想是将数组分成两部分，分别进行排序，然后归并起来。

![merge_sort](./image/merge_sort.png)

```java
/**
     * 自顶而下分组归并
     */
    private static void sort(int[] input, int left, int right){
        if (left >= right){//只有一个元素，无需排序
            return;
        }

        int middle = left + (right - left) / 2;
        sort(input, left, middle);
        sort(input, middle + 1, right);
        merge(input,left,middle,right);
    }


//归并
    private static void merge(int[] input,int left,int middle,int right){
        int p = left;
        int q = middle + 1;
        //复制数组数据，放入临时数组
        for (int i = left; i <= right; i++) {
            temp[i] = input[i];
        }

        for (int k = left; k <= right; k++) {
            if (p > middle){
                input[k] = temp[q++];
            }else if (q > right){
                input[k] = temp[p++];
            }else if (temp[p] <= temp[q]){//这里比较的是temp，不是input，一不小心就写成input了，切记！切记！
                input[k] = temp[p++];
            }else {
                input[k] = temp[q++];
            }
        }
    }
```

