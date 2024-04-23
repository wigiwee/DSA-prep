import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Stack;

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
class Example{
    public void reverseStringUsingStack(String str){
        char[] charArray = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            stack.push(charArray[i]);
        }
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = stack.pop();
        }
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]);
        }
        System.out.println();

    }
    /*
    Q. Given an array of integers. For each element in the array, find tis next greater element in the array,
    The next greater element is the first towards right, which is greater than the current element.
    exmaple-
    intput arr={4,7,3,4,8,1,}
    output arr={7,8,4,8,-1,-1}
     */
    public int[] nextGreaterElement(int[] arr){
        int[] result = new int[arr.length];
        StackUsingArray stack = new StackUsingArray(arr.length);
        for (int i = arr.length-1; i >=0 ; i--) {
            while (!stack.isEmpty() && arr[i]>stack.peek()){
                try {
                    stack.pop();
                }catch (Exception e) {
                }
            }
            if(stack.isEmpty()){
                result[i] = -1;
            }else {
                result[i] = stack.peek();
            }
            try {
                stack.push(arr[i]);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
    public boolean validParenthesis(String str){
        char[] charArray = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] =='{' || charArray[i] =='(' || charArray[i] =='['  ){
                stack.push(charArray[i]);
            } else if (charArray[i] =='}' ) {
                if(stack.peek() != '{'){
                    return false;
                }else {
                    stack.pop();
                }
            }else if (charArray[i] ==')' ) {
                if(stack.peek() != '('){
                    return false;
                }else {
                    stack.pop();
                }
            }else if (charArray[i] ==']' ) {
                if(stack.peek() != '['){
                    return false;
                }else {
                    stack.pop();
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Example example = new Example();
        example.reverseStringUsingStack("hello");
        example.reverseStringUsingStack("racecar");
        example.reverseStringUsingStack("done");
        int[] arr={4,7,3,4,8,1,};
        int [] result =example.nextGreaterElement(arr);
        System.out.println(Arrays.toString(result));
        System.out.println(example.validParenthesis("{{()[}}]"));
        System.out.println(example.validParenthesis("{hello( ) everyone []}"));

    }


}
