import javax.swing.plaf.IconUIResource;
import java.util.List;

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
        ListNode current = this.head;
        int i = 1;
        while (index > i){

        }
    }


    public static void main(String[] args){
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
        sll.insertNode(5,21);
        System.out.println("New Linked list is: " );
        sll.print();
        System.out.println("Deleting first node of the Singly list list");
        sll.deleteFirstNode();
        sll.print();
        System.out.println("Deleting last node of the Singly linked list");
        sll.deleteLastNode();
        sll.print();

    }
}
