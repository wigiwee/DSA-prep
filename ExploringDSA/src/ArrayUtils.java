import java.util.Arrays;

public class ArrayUtils {
    public static void main(String[] args) throws Exception {
        ArrayUtils arrayUtils = new ArrayUtils();
        int[] numbers = {45, 0,44, 55,0,0,0, 87, 36, 42,0, 15, 48, 69,0, 85, 97,0, 58, 5,0};
        System.out.println(Arrays.toString((numbers)));
        System.out.println("minimum value in the array is : " + ArrayUtils.minimumValue(numbers));
        System.out.println("Second maximum value in the array is : " + ArrayUtils.secondMaximumValue(numbers));
        System.out.println("Zeros at the end order of the array s : \n" + Arrays.toString(ArrayUtils.moveZerosToEnd(numbers)));
        int[] array = {1,8,9,6,5,4,2};
        System.out.println("array before resizing is " + Arrays.toString(array));
        array = ArrayUtils.resize(array , 13);
        System.out.println("New resized array is " + Arrays.toString(array));
        int[] intArray = {6,5,2,3,1};
        System.out.println("The missing number from the intArray is : " + ArrayUtils.findMissingNumber(intArray));


    }

    public static int[] reverseArray(int[] numbers){
        int start = 0 , end = numbers.length-1;
        int temp;
        while ( start<end){
            temp = numbers[end];
            numbers[end] = numbers[start];
            numbers[start] = temp;
            start ++;
            end --;
        }

        return numbers;
    }
    public static int minimumValue(int[] numbers) throws Exception {
        if(numbers.length == 0){
            throw new Exception("Invalid Input");
        }
        int min = numbers[0];
        for (int i = 1; i <numbers.length; i++) {
            if(min>numbers[i]){
                min = numbers[i];
            }
        }
        return  min;
    }
    public static int secondMaximumValue(int[] numbers ) throws Exception{
        if(numbers.length<2){
            throw new Exception("Invalid input array");
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]>max){
                secondMax = max;
                max = numbers[i];
            } else if (numbers[i]>secondMax && numbers[i] != max) {
                secondMax = numbers[i];
            }
        }
        return secondMax;
    }
    public static int[] moveZerosToEnd(int[] numbers){
        int j = 0 ;
        int temp ;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[j]==0 && numbers[i] !=0){
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j]= temp;
            }
            if(numbers[j] !=0){
                j++;
            }

        }
        return numbers;
    }
    public static int[] resize(int[] array , int newSize){
        int[] newArray = new int[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i]= array[i];
        }
        return newArray;
    }
    //Q. an array of size n contains numbers from 1 to n+1 but one of the number is missing, find which number is missing,
    public static int findMissingNumber(int[] array ) {
        int n  = array.length+1;
        int arraySum= n*(n+1)/2;
        for (int j : array) {
            arraySum = arraySum - j;

        }
        return arraySum;
    }


}
