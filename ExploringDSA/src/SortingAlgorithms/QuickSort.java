package SortingAlgorithms;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] input, int start, int end){
        if(end-start < 2){
            return;
        }

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex-1, end);
    }

    public static int partition(int[] input, int start, int end) {
        
        int pivot = input[start];
        int i = start;
        int j = end;
        while(i < j){
            while(i < j && input[--j]  >= pivot);
            if(i<j){
                input[i] = input [j];
            }

            while(i < j && input[++i] <= pivot);
            if(i< j){
                input[j] = input[i];
            }
        }

        input[j] = pivot;
        return j;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{12,45,69,89,77,45,23,11,69,35};
        QuickSort.quickSort(arr, 0, arr.length);
        System.out.println(Arrays.toString( arr));

    }
}
