#include <stdio.h>

int linearSearch(int arr[],int size, int key) {
    for(int i = 0; i < size; i++){
        if(arr[i] == key){
            return i;
        }
    }
    return -1;
}

int binarySearch(int arr[],int size, int key){
    int mid, low, high;
    low = 0;
    high = size -1;

    while(low <=high){
        mid = (high + low)/2;       // 5.5 = 5 (will be rounded of to lowest integer)
        if(arr[mid]== key){
            return mid;
        }
        if(arr[mid]< key){
            low = mid+1;
        }
        if(arr[mid]>key){
            high = mid-1;
        }
    }
    return -1;
}

int main() {
    
    int arr[] = {1, 2, 3, 4, 5,223,2,323, 2, 2323, 23, 22, 7, 72, 20, 38,3};
    int size = sizeof(arr)/sizeof(int);
    int searchIndex = linearSearch(arr,size, 323);
    printf("element %d was found at index %d \n", 323, searchIndex);

    int sortedArr[] = {1,12,13,16,20,25,26,29,30,33,39,45,55,57,90};
    size = sizeof(sortedArr)/sizeof(int);
    searchIndex = binarySearch(sortedArr, size, 33);
    printf("element %d was found at index %d \n", 33, searchIndex);

    return 0;
}