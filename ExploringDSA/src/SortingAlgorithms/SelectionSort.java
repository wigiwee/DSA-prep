package SortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {
    //in-place algorithm
    //time complexity O(n^2)
    //unstable algorithm
    //nomally better than bubble sort
    public static int[] selectionSort(int[] array){
        int largestElementIndex,temp;
        for(int lastUnsortedIndex = array.length-1; lastUnsortedIndex>0; lastUnsortedIndex--){
            largestElementIndex=0;
            for(int i = 1; i <= lastUnsortedIndex; i++){
                if(array[i] > array[largestElementIndex]){
                    largestElementIndex = i;
                }
            }
            temp = array[lastUnsortedIndex];
            array[lastUnsortedIndex] = array[largestElementIndex];
            array[largestElementIndex] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SelectionSort.selectionSort(new int[]{3,57,96,4,51,23,69,46,73,83,26})));
    }
}
