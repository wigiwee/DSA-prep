package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {

    //not a inplace algorithm
    //stable algorithm
    //memory extensive but fast
    //O(nlogn) time complexity algorithm

    public static void mergeSort(int[] input, int start , int end){
        if(end - start< 2){
            return;
        }
        int mid = (start + end )/2;
        mergeSort(input, start, mid);
        mergeSort(input, mid+1, end);
        merge(input, start, mid, end);
    }
    public static void merge(int[] input, int start, int mid, int end){
        int i = 0;
        int j = mid+1;
        int[] temp = new int[end - start];
        int tempIndex = 0;
        while(tempIndex < temp.length){


        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12,45,69,89,77,45,23,11,69,35};
        MergeSort.mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString( arr));

    }
}
