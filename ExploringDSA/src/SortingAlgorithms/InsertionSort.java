package SortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {
    //a lot of shifting
    //can be improved with shell sort
    public static int[] insertionSort(int[] array){
        int i, newElement;
        for(int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++){
            newElement = array[firstUnsortedIndex];
            for(i = firstUnsortedIndex; i>0 && array[i-1] > newElement; i--){
                array[i] = array[i-1];
            }
            array[i] = newElement;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(InsertionSort.insertionSort(new int[] {23,6,69,78,15,36,45,29,4,62})));
    }
}
