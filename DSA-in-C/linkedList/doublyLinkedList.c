#include <stdio.h>
#include <stdlib.h>

struct node{
    int data;
    struct node * next;
    struct node * prev;
};

void createNode(struct node * newNode, int data){
    newNode->data = data;   
    newNode->next = NULL;
    newNode->prev = NULL; 
}

void createList(struct node * head, int arr[], int size){

    struct node * curr = head;
    struct node * prev = NULL;
    struct node * next = NULL;
    for(int i = 0 ; i < size; i++){
        curr->data = arr[i];
        next = (struct node *)malloc(sizeof(struct node));
        curr->next = next;
        curr->prev = prev;
        curr = next;
        prev = curr;
    }

    prev->next = NULL;
}

void printForward(struct node * head, int size){
    struct node * curr = head;
    printf("NULL<-");
    while(curr->next != NULL){
        printf("%d<=>", curr->data);
        curr = curr->next;
    }
    printf("->NULL\n");
}

void printBackward(struct node * head, int size){
    struct node * curr;
        while(curr->next != NULL){
        curr = curr->next;
    }
    printf("%d\n",curr->data);
    printf("NULL->");
    while(curr->prev != NULL){
        printf("%d<=>", curr->data);
        curr = curr->prev;  
    }
    printf("->NULL\n");
}

void insert(struct node * head, int index, int data, int size){
    if(index > size){
        printf("invalid index \n");
    }
    struct node * curr = head;
    for(int i = 1; i < index; i++){
        curr = curr->next;
    }
    struct node * newNode = (struct node *)malloc(sizeof(struct node));
    newNode->data = data;
    struct node * temp;
    temp = curr->next;
    curr->next = newNode;
    newNode->prev = curr;
    newNode->next = temp;
    temp->prev = newNode;
}

struct node * delete(struct node * head, int index, int size){
    if(index >= size){
        printf("Invalid index");
        return NULL;
    }
    struct node * curr = head;
    for(int i = 1; i< index; i++){
        curr = curr->next;
    }
    struct node * deletedNode = curr->next;
    curr->next = deletedNode->next;
    deletedNode->next->prev = curr;
    deletedNode->next = NULL;
    deletedNode->prev = NULL;
    return deletedNode;
}
int main(){

    struct node head;
    createNode(&head, 0);
    int arr[] = {1,6,3,2,6,7};
    int size = sizeof(arr)/sizeof(int);
    createList(&head, arr, size);
    printForward(&head, size);
    insert(&head, 3, 99, size);
    size++;
    printForward(&head, size);
    // printBackward(&head, size);
    delete(&head, 4, size);
    size--;
    printForward(&head, size);
    return 0;
}
