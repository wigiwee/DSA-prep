#include <stdio.h>
#include <stdlib.h>

struct node{
    struct node * next;
    int data;
};

void createNode(struct node * node, int data){
    node->data = data;
    node->next = NULL;
}

void createLinkedList(struct node * head, int arr[], int size){    
    head->data = arr[0];
    struct node * prevAddr = head;
    struct node * nextNode = (struct node *)malloc(sizeof(struct node));
    for(int i = 1; i < size; i++){
        createNode(nextNode, arr[i]);
        prevAddr->next = nextNode;
        prevAddr = nextNode;
        nextNode = (struct node *)malloc(sizeof(struct node));

    }
    prevAddr = NULL;
}

void printLinkedList(struct node * head, int size){
    struct node * nodeAddr = head;
    for (int i = 0; i < size; i++) {
    // while (nodeAddr->next != NULL) {
        printf("%d->", nodeAddr->data);
        nodeAddr = nodeAddr->next;    
    }
    printf("NULL\n");
}

void insert(struct node * head, int size, int index, int data){
    struct node * currentNode = head;
    for(int i = 0; i < index-1; i++){
        currentNode = currentNode->next;
    }
    struct node * newNode = (struct node*)malloc(sizeof(struct node));
    createNode(newNode, data);
    struct node * temp;
    temp = currentNode->next;
    currentNode->next = newNode;
    newNode->next = temp;
}

int delete(struct node * head, int size, int index){
    struct node * currentNode = head;
    for(int i = 0; i < index-1; i++){
        currentNode = currentNode->next;
    }
    struct node * deletedNode = currentNode->next;
    currentNode->next = currentNode->next->next;

    deletedNode->next = NULL;
    return deletedNode->data;
}

int main(){

    struct node head;
    createNode(&head, -1);
    int arr[] = {9, 3, 5, 2, 4};
    createLinkedList(&head, arr, 5);
    printLinkedList(&head, 5);
    insert(&head, 5, 2, 1);
    printLinkedList(&head, 6);
    delete(&head, 6, 2);
    printLinkedList(&head, 5);

    return 0;
}