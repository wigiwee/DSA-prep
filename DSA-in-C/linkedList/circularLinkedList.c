#include <stdio.h>
#include <stdlib.h>

struct node{
    int data;
    struct node * next;
};

void createNode(struct node * node, int data){
    node->data = data;
    node->next = NULL;
}

void createCLL(struct node * head, int arr[], int size){
    
    head->data = arr[0];
    struct node * nextNode = (struct node * )malloc(sizeof(struct node));
    struct node * prevAddr = head;
    for(int i = 1; i < size; i++ ){
        createNode(nextNode, arr[i]);
        prevAddr->next = nextNode;
        prevAddr = nextNode;
        nextNode = (struct node * )malloc(sizeof(struct node));
    }
    prevAddr->next = head;
    
}

void printLinkedList(struct node * head, int size){
    struct node * nodeAddr = head;
    for (int i = 0; i < size; i++) {
    // while (nodeAddr->next != NULL) {
        printf("%d->", nodeAddr->data);
        nodeAddr = nodeAddr->next;    
    }
    printf("to first element\n");
}

struct node * deleteElement(struct node * head, int size, int index){
    if(index >= size){
        printf("invalid index");
        return NULL;
    }
    struct node * currNode = head;
    for(int i = 1 ; i< index; i++){
        currNode = currNode->next;
    }
    struct node * deletedNode = currNode->next;
    currNode->next = deletedNode->next;
    deletedNode->next = NULL;
    return deletedNode;
}

void insert(struct node * head, int size, int data, int index){
    if(index > size){
    printf("invalid index\n");
        return;    
    }
    struct node * currNode = head;
    struct node * newNode = (struct node *)malloc(sizeof(struct node));
    newNode->data = data;
    for(int i = 1; i < index; i++){
        currNode = currNode->next;
    }
    struct node * temp = currNode->next;
    currNode->next = newNode;
    newNode->next = temp;
    return;
}
int main(){
    struct node head;
    createNode(&head, -1);
    int arr[] = {3,5,2,6,3};
    int size = sizeof(arr)/sizeof(int);
    createCLL(&head, arr, size);
    printLinkedList(&head, size);
    struct node * deletedNode = deleteElement(&head, size, 2);
    size--;
    printf("%d\n", deletedNode->data);
    printLinkedList(&head, size);
    insert(&head, size, 88, 4);
    size++;
    printLinkedList(&head, size);
    return 0;
}