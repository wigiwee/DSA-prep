public class SinglyLinkedList {
    private ListNode head;
    private static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void print() {
        ListNode current = this.head;
        while (current.next != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println(current.data);
    }
    public int length(){
        ListNode current = this.head;
        int count=1;
        while(current.next !=null){
            count++;
            current = current.next;
        }
        return count;
    }
    public void insertAtBeginning(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = this.head;
        this.head = newNode;
    }
    public void insertAtEnd (int data){
        ListNode newNode = new ListNode(data);
        newNode.next = null;
        if(this.head == null){
            this.head = newNode;
            return;
        }
        ListNode current = this.head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = newNode;
    }
    public void insertNode(int index, int data){
        if(index == 0 ){
            insertAtBeginning(data);
            return;
        }
        ListNode newNode = new ListNode(data);
        if(this.head == null){
            this.head = newNode;
            newNode.next = null;
            return;
        }
        int i=1;
        ListNode current = this.head;
        while (i != index){
            current = current.next;
            i++;
        }
        ListNode temp = current.next;
        current.next = newNode;
        newNode.next = temp;
    }
    public ListNode deleteFirstNode(){
        if(this.head == null){
            return null;
        }
        ListNode deletedNode = this.head;
        this.head = this.head.next;
        deletedNode.next = null;
        return deletedNode;
    }
    public ListNode deleteLastNode(){
        if(this.head == null){
            return null;
        }
        if(this.head.next == null){
            ListNode temp = this.head;
            this.head = null;
            return temp;
        }
        ListNode current = this.head;
        while(current.next.next != null){
            current = current.next;
        }
        ListNode temp = current.next;
        current.next = null;
        return temp;
    }
    public ListNode deleteNode(int index){
        if(index ==0){
            return deleteFirstNode();
        }
        ListNode current = this.head;
        int i  = 0;
        while (i!=index-1){
            current = current.next;
            i++;
        }
        ListNode deletedNode = current.next;
        if (deletedNode.next == null){
            current.next = null;
            return deletedNode;
        }
        current.next = deletedNode.next;
        deletedNode.next = null;
        return deletedNode;
    }
    public int serach(int element){
        int index = 0;
        ListNode current = this.head;
        while(current.data!= element){
            if(current.next == null){
                return  -1;
            }
            current = current.next;
            index++;
        }
        return index;
    }
    public void reverseList(){

        ListNode current = this.head;
        if(current.next == null){
            return;
        }
        ListNode next = null;
        ListNode previous = null;
        while(current.next != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }
        current.next = previous;
        this.head = current;
    }
    public ListNode middleNode(){
        if(head == null){
            return  null;
        }
        ListNode fastPtr = this.head;
        ListNode slowPtr = this.head;
        while(fastPtr!= null && slowPtr!= null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
    public ListNode find(int index) throws Exception{
        ListNode current = this.head;
        int n = 0;
        while(index != n){
            if(current == null || index<0){
                throw new Exception("index out of bound");
            }
            current = current.next;
            n++;
        }
        return current;
    }

    //Q. A sorted linked list is given, remove the duplicates from the linked link list an
    public void removeDuplicatesInSortedLinkedList(){
        ListNode current = head;
        while (current!= null && current.next!=null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
    }

    //Q. Insert a node in sorted singly linked list
    public void insertNodeInSortedLinkedList(int data){
            ListNode current = this.head;
            ListNode newNode = new ListNode(data);
            while(current.next !=null){
                if(current.data > data && current.next.data<data) {
                    newNode.next = current.next;
                    current.next = newNode;
                    return;
                }
            }
            current.next =  newNode;
            newNode.next = null;
    }
    public void removeGivenNode(int data){
        ListNode current = this.head;
        if(current.data == data) {
            this.deleteFirstNode();
            return;
        }
        while (current.next.data != data ){
            if(current.next== null){
                break;
            }
            current = current.next;
        }
        current.next = current.next.next;
    }
    public ListNode startingPointOfLoop(){
        ListNode fastPtr = this.head;
        ListNode slowPtr = this.head;
        while (fastPtr.next !=null && fastPtr !=null){
            fastPtr= fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                ListNode temp = this.head;
                while(temp != slowPtr){
                    temp = temp.next;
                    slowPtr = slowPtr.next;
                }
                return temp;
            }
        }
        return null;
    }
    public void removeLoop(){
        ListNode fastPtr = this.head;
        ListNode slowPtr = this.head;
        while (fastPtr.next !=null && fastPtr !=null){
            fastPtr= fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                ListNode temp = this.head;
                while(temp.next != slowPtr){
                    temp = temp.next;
                    slowPtr = slowPtr.next;
                }
                slowPtr.next = null;
                return;
            }
        }

    }
    //Q. Write a method to merge two sorted singly linked list
    public ListNode mergeTwoSortedLists(ListNode list1, ListNode list2){
        ListNode sortedListHead = new ListNode(0);
        ListNode tail = sortedListHead;
        while (list1!=null && list2!=null){
            if(list2.data >= list1.data){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        if(list2 == null){
            tail.next = list1;
        }else if (list1 == null){
            tail.next = list2;
        }
        return sortedListHead.next;
    }
/*
Q. Given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and
each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/
    public static ListNode addTwoLists(ListNode list1 , ListNode list2){
        ListNode sumListHead = new ListNode(0);
        ListNode tail  = sumListHead;
        int sum = 0 , carry = 0;
        while (list1!=null && list2!=null){
            sum = list1.data+ list2.data+ carry;
            carry = 0;
            if(sum>=10){
                ListNode newNode = new ListNode(sum%10);
                carry = 1;
                tail.next = newNode;
            }else {
                ListNode newNode = new ListNode(sum);
                tail.next = newNode;
            }
        }
        if(list1 == null && list2 != null){
            tail.next = list2;
            tail.next.data = tail.next.data+carry;
        } else if ( list2 != null && list2 == null) {
            tail.next = list1;
            tail.next.data = tail.next.data+carry;
        } else if (carry != 0 ){
            tail.next = new ListNode(carry);
            tail = tail.next;
            tail.next = null;
        }


        return sumListHead.next;
    }
    public static void main(String[] args) throws Exception{
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;

        System.out.println("Linked list is:");
        sll.print();
        System.out.println("Length of linked list is: " + sll.length());
        System.out.println("Inserting 4 at the beginning of the Singly linked list");
        sll.insertAtBeginning(4);
        System.out.println("New Linked list is: " );
        sll.print();
        System.out.println("Inserting 4 at the end of the Singly linked list");
        sll.insertAtEnd(15);
        System.out.println("New Linked list is: " );
        sll.print();
        System.out.println("Inserting 21 at 3nd position of the Singly linked list");
        sll.insertNode(5,9);
        System.out.println("New Linked list is: " );
        sll.print();
        System.out.println("Deleting first node of the Singly list list");
        sll.deleteFirstNode();
        sll.print();
        System.out.println("Deleting last node of the Singly linked list");
        sll.deleteLastNode();
        sll.print();
        System.out.println("Singly Linked List after deleting node at index 2 is: ");
        sll.deleteNode(0);
        sll.print();
        System.out.println("The index of 11 in Singly Linked List is : "+ sll.serach(11));
        System.out.println("The index of 22 in Singly Linked List is : "+ sll.serach(22));
        System.out.println("Reversed Linked List is :" );
        sll.reverseList();
        sll.print();
        System.out.println("Middle node is : " + sll.middleNode().data);
        System.out.println("The element at index 3 is : " + sll.find(3).data);
        System.out.println("Removing node with data 11 from Singly linked list:");
        sll.removeGivenNode(11);
        sll.print();
        sll.reverseList();
        //created second sorted linked list:
        ListNode firstNode = new ListNode(2);
        ListNode secondNode = new ListNode(4);
        ListNode thirdNode = new ListNode(8);
        ListNode fourthNode = new ListNode(9);
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = null;
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.head = firstNode;

        System.out.println("first sorted linked list is :");
        sll.print();
        System.out.println("Second sorted linked list is : ");
        list2.print();
        SinglyLinkedList  mergedSortedLinkedList = new SinglyLinkedList();
        mergedSortedLinkedList.head = mergedSortedLinkedList.mergeTwoSortedLists(sll.head, list2.head);
        System.out.println("the merge of both sorted linked list is:");
        mergedSortedLinkedList.print();
        // adding list 1 and list 2
        System.out.println("list1 is : ");
        sll.print();;
        System.out.println("list2 is : ");
        list2.print();
        System.out.println("the addition of the above two linked list is:");
        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.head = addTwoLists(sll.head, list2.head);
        list3.print();
    }
}