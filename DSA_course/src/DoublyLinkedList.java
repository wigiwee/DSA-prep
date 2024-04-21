import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head ;
    private ListNode tail;
    private int length;

    private class ListNode {
        private ListNode next;
        private ListNode previous;
        private int data;
        public ListNode(int data){
            this.data = data;
        }
    }
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public boolean isEmpty(){
        return length == 0;
    }
    public int length(){
        return length;
    }
    public void print(){
        ListNode current = this.head;
        System.out.print("null <==> ");
        while (current!= null){
            System.out.print(current.data +" <==> ");
            current = current.next;
        }
        System.out.println("null");

    }
    public void insertLast(int data){
        if(isEmpty()){
            tail = new ListNode(data);
            head = tail;
        }else {

            tail.next = new ListNode(data);
            tail.next.previous = tail;
            tail = tail.next;
        }
        length++;

    }
    public void insertAtBeginning(int data){
        if(isEmpty()){
            head = new ListNode(data);
            tail = head;
        }else {
            head.previous = new ListNode(data);
            ListNode temp = head;
            head = head.previous;
            head.next = temp;
            head.previous = null;
        }
        length++;
    }
    public ListNode deleteFirstNode() throws Exception{
        if(isEmpty()){
            throw new NoSuchElementException();
        }else {
            ListNode temp = this.head;
            if(head == tail){
                head = null;
                tail = null;
            }else {
                head = head.next;
                head.previous = null;
            }
            temp.next = null;
            length--;
            return  temp;
        }

    }
    public ListNode deleteLastNode() throws Exception{
        if(isEmpty()){
            throw new NoSuchElementException();
        }else {
            ListNode lastNode = this.tail;
            tail = tail.previous;
            tail.next = null;

            lastNode.previous = null;
            length--;
            return lastNode;
        }

    }

    public static void main(String[] args) throws Exception{
        DoublyLinkedList dll = new DoublyLinkedList();
        System.out.println("Our Linked List is :");
        dll.insertLast(44);
        dll.insertLast(12);
        dll.insertLast(23);
        dll.insertLast(24);
        dll.print();
        System.out.println("List after inserting 15 at end is:");
        dll.insertLast(15);
        dll.print();
        System.out.println("List after inserting 14 at the beginning is :");
        dll.insertAtBeginning(14);
        dll.print();
        System.out.println("List after deleting first node is: ");
        dll.deleteFirstNode();
        dll.print();
        System.out.println("List after deleting last node is: ");
        dll.deleteLastNode();
        dll.print();
    }
}
