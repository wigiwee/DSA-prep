import java.util.Arrays;
import java.util.NoSuchElementException;

public class StackUsingArray {
    private int top;
    private int length;
    private int[] array;
    public StackUsingArray(int stackLength){
        top = -1;
        length = 0;
        array = new int[stackLength];
    }
    public boolean isFull(){
        return array.length ==(top+1);
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public int length(){
        return length;
    }
    public void push(int data) throws Exception {
        if(isFull()){
            throw new Exception("Stack is full");
        }else {
            array[top+1] = data;
            top++;
            length++;
        }

    }
    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is Empty");
        }else {
            int result = array[top];
            top --;
            length--;
            return result;
        }
    }
    public void print(){
        int i =0;
        System.out.print("[ ");

        while (i != top+1){
            System.out.print(array[i]+", ");
            i++;
        }
        System.out.println("\b\b ] ");
    }
    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }else {
            return array[top];
        }
    }

    public static void main(String[] args) throws Exception {
        StackUsingArray stack = new StackUsingArray(5);
        stack.push(4);
        stack.push(6);
        stack.push(2);
        stack.push(1);
        stack.push(6);
        stack.pop();
        stack.push(9);
        stack.print();
        System.out.println("Result of peek is: "+ stack.peek());

    }

}
