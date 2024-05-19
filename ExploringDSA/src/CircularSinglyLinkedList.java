import java.util.List;
import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {
    private ListNode last ;
    private int length;

    private class ListNode {
        private ListNode next ;
        private int data;

        public ListNode(int data){
            this.data = data;
        }
    }
    public CircularSinglyLinkedList (){
        last = null;
        length =0;
    }
    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public void createCircularLinkedList(){
        ListNode first = new ListNode(3);
        ListNode second = new ListNode(15);
        ListNode third  = new ListNode(31);
        ListNode fourth  = new ListNode(14);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        this.last = fourth;
        length = 4;
    }
    public void print(){
        if(this.last == null){
            return;
        }else {
            ListNode temp = last.next;
            while (temp != last){
                System.out.print(temp.data+" -> ");
                temp = temp.next;
            }
            System.out.println(temp.data+" -> first node");
        }
    }
    public void insertAtBeginning(int data){
        ListNode newNode = new ListNode(data);
        if(last == null){
            this.last = newNode;
            newNode.next = newNode;
            length++;
        }else {
            ListNode firstNode = last.next;
            last.next = newNode;
            newNode.next = firstNode;
            length++;
        }
    }
    public void insertAtEnd(int data){
        ListNode newNode = new ListNode(data);
        if(last ==null){
            this.last = newNode;
            newNode.next = newNode;
            length++;
        }else {
            ListNode firstNode = last.next;
            last.next = newNode;
            newNode.next = firstNode;
            last = last.next;
            length++;
        }
    }
    public ListNode deleteFirstNode(){
        if(length == 0){
            throw new NoSuchElementException();
        }else if (length == 1) {
            ListNode lastNode = last;
            this.last = null;
            return lastNode;

        } else {
            ListNode firstNode = last.next;
            last.next = firstNode.next;
            firstNode.next = null;
            length--;
            return firstNode;
        }
    }
    public ListNode deleteLastNode(){
        if(length == 0){
            throw new NoSuchElementException();
        } else if (length == 1) {
            ListNode lastNode = last;
            this.last = null;
            return lastNode;

        } else {
            ListNode lastNode= last;
            ListNode temp = last.next;
            while(temp.next != last){
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp;
            length--;
            lastNode.next = null;
            return lastNode;
        }
    }
    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCircularLinkedList();
        csll.print();
        System.out.println("List After inserting 2 at the beginning :");
        csll.insertAtBeginning(2);
        csll.print();
        System.out.println("List After inserting 4 at the end :");
        csll.insertAtEnd(4);
        csll.print();
        System.out.println("List after deleting first node :");
        csll.deleteFirstNode();
        csll.print();
        System.out.println("List after deleting last node :");
        csll.deleteLastNode();
        csll.print();

    }

}
