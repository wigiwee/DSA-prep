package SortingAlgorithms;

import java.util.Arrays;

public class ShellSort {

    //variation of insertion sort(insertion sort is shell sort with gap=1)
    //better for nearly sorted arrays
    //this algorithm is unstable unlike insertion sort
    public static int[] shellSort(int[] array){

        for (int gap = array.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < array.length; i++) {

                int newElement = array[i];

                int j = i;

                while ((j >= gap) && (array[j - gap] > newElement)) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = newElement;
            }
        }

        return array;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ShellSort.shellSort(new int[]{3, 57, 96, 4, 51, 23, 69, 46, 73, 83, 26})));
    }
}
