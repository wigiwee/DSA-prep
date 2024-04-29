import java.util.NoSuchElementException;

public class QueueUsingLinkedList {
    private ListNode rear;
    private ListNode front;
    private int length;
    private class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public QueueUsingLinkedList(){
        this.rear = null;
        this.front = null;
        this.length = 0;
    }
    public void print(){
        System.out.print("front-> ");
        ListNode temp = front;
        while(temp!= null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println(" rear");
    }
    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length==0;
    }

    public void enqueue(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            this.front =newNode;
            length++;
        }else {
            rear.next = newNode;
            length++;
        }
        this.rear = newNode;
    }
    public ListNode dequeue(){
        if(isEmpty()){
            return null;
        }else {
            ListNode deletedNode = front;
            front = front.next;
            if(front == null) rear = null;
            deletedNode.next = null;
            length--;
            return deletedNode;
        }
    }
    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(7);
        queue.enqueue(9);
        queue.print();
        queue.dequeue();
        queue.print();

    }
}