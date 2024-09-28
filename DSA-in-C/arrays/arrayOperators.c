#include <stdio.h>

void display( int arr[], int size){
    
    //traversal
    for(int i =0; i < size; i++){
        printf("%d", arr[i]);
        printf("-");
    }
    printf("\n");
}

int indexInsertion(int arr[], int size, int element, int capacity, int index){
    if(size >=capacity){
        return -1;
    }else{
        for(int i = size-1; i >= index; i-- ){
            arr[i+1] = arr[i];
        }
        arr[index] = element;
    }
    return 1;
}

int deletion(int arr[], int size, int index){
    if(index>=size){
        return -1;
    }else {
        int deletedElement = arr[index];
        for(int i = index; i < size; i++){
            arr[i] = arr[i+1];
        }
        return deletedElement;
    }
}

int forceInsertion(int arr[], int element, int size, int index){
    if(index >= size && index >=0){
        return -1;
    }else{
        int replacedElement = arr[index];
        arr[index] = element;
        return replacedElement;
    }
}

int main(){

    int arr[100] = {1,2,3,4};
    int size = 4;
    display(arr,size);
    indexInsertion(arr, 4, 12, 100, 3);
    size++;
    display(arr,size);
    deletion(arr, size, 0);
    size--;
    display(arr, size);
    return 0;
}