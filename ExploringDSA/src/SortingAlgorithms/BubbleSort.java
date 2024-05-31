package SortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    //in-place algorithm - means no extra memory needed
    //complexity O(n^2) 10 elements take 10,000 steps
    //Algorithm degrades quickly
    //stable sort algorithm
    public static int[] bubblesort(int[] array){
        int temp;
        for(int unsortedPartitionIndex = array.length-1; unsortedPartitionIndex !=1; unsortedPartitionIndex--){
            for(int i = 0 ; i < unsortedPartitionIndex; i++){
                if(array[i]>array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(BubbleSort.bubblesort(new int[] {5,4,9,15,78,27,96,24,19,86,43,55})));
    }
}
