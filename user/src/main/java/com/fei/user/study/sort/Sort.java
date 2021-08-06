package com.fei.user.study.sort;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhangxinfei
 * create at:  2021/7/21  3:08 下午
 * @description:
 */
public class Sort {

    /**
     * @Des 冒泡排序
     */
    public static int[] bubbleSort(int[] array){
        if (array.length == 0){
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j+1] < array[i]){
                    int temp = array[j+1];
                    array[j+1] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 选择排序
     */
    public static int[] selectionSort(int[] array){
       if (array.length == 0){
           return array;
       }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * 插入排序
     */
    public static int[] insertionSort(int[] array){
        if (array.length == 0){
            return array;
        }
        //需要插入的数据
        int temp;
        for (int i = 0; i <array.length - 1; i++) {
            temp = array[i+1];
            //数据比较位置的下标
            int preIndex = i;
            //从后往前一个一个比较，直到比较的数据比需要插入的数据大了，然后停止比较退出循环
            while (preIndex >= 0 && temp < array[preIndex]){
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = temp;
        }
        return array;
    }

    /**
     * 希尔排序，插入排序的增强版，把排序的范围由小到大去扩展
     */
    public static int[] ShellSort(int[] array){
        int len = array.length;
        int temp, gap = len/2;
        while (gap > 0){
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp){
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    /**
     * 归并排序
     */
    public static int[] MergeSort(int[] array){
        if(array.length < 2){
            return array;
        }
        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array,0,mid);
        int[] right = Arrays.copyOfRange(array,mid,array.length);
        return merge(MergeSort(left), MergeSort(right));
    }

    /**
     * 归并排序--将两段排序好的数组结合成一个排序数组
     */
    public static int[] merge(int[] left,int[] right){
        int[] result = new int[left.length + right.length];
        for (int index=0,i=0,j=0;index< result.length;index++){
            if (i >= left.length){
                result[index] = right[j++];
            }else if (j >= right.length){
                result[index] = right[j++];
            } else if (left[i] > right[j]){
                result[index] = left[i++];
            }
        }
        return result;
    }

    /**
     *
     */
    public static int getIndex(int[] arr, int low, int high){
        //基准数据
        int temp = arr[low];
        while (low < high){
            //当队尾的元素大于等于基准数据时，向前挪动high指针
            while (low < high && arr[high] >= temp){
                high--;
            }
            //如果队尾元素小于temp了，需要将其复制给low
            arr[low] = arr[high];
            //当队首元素小于等于temp时，向前挪动low指针
            while (low < high && arr[low] <= temp){
                low++;
            }
            //当队首元素大于temp时，需要将其复制给high
            arr[high] = arr[low];
        }
        //跳出循环时low和high相等，此时的low或high就是temp的正确索引位置
        //由原始部分可以很清楚的知道low位置的值并不是temp，所以需要将temp复制给arr[low]
        arr[low] = temp;
        return low;//返回temp的位置
    }

    /**
     * 快速排序
     * @param arr 需要排序的数组
     * @param low 数组起始位置
     * @param high 数组结束位置
     */
    public static void quickSort(int[] arr, int low, int high){
        if (low < high){
            //找寻基准数据的正确索引
            int index = getIndex(arr,low,high);

            //进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(arr,0,index-1);
            quickSort(arr,index+1,high);
        }
    }

    public static void main(String[] args){
        int[] arr = {3,8,1,9,2,7,4,5,6};
        quickSort(arr,0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


}
