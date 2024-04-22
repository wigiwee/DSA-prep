import java.util.NoSuchElementException;

public class StackUsingLinkedList {
    //implementation of stack using linked list
    private ListNode top;
    private int length;

    private class ListNode {
        private ListNode next;
        private  int data;
        public ListNode(int data){
            this.data = data;
        }
    }
    private StackUsingLinkedList(){
        this.length = 0 ;
        this.top = null;
    }
    public void push(int data){
        ListNode newNode = new ListNode(data);
        if(length ==0){
            this.top = newNode;
            newNode.next = null;
        }else {
            newNode.next = this.top;
            this.top = newNode;
        }
        length++;
    }
    public void print(){
        ListNode temp = this.top;
        System.out.print("top-> ");
        while (temp!= null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public ListNode pop(){
        if(length == 0){
            throw new NoSuchElementException();
        }else {
            ListNode deletedNode = top;
            top = top.next;
            deletedNode.next = null;
            length--;
            return deletedNode;
        }
    }
    public boolean isEmpty(){
        return length==0;
    }
    public int length(){
        return length;
    }
    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }else {
            return top.data;
        }
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(5);
        stack.push(4);
        stack.push(6);
        stack.push(7);
        stack.push(1);
        System.out.println("Stack is: ");
        stack.print();
        System.out.println("Stack after pop operation:");
        stack.pop();
        stack.print();
        System.out.println("Peek operation result: "+ stack.peek());

    }
}
