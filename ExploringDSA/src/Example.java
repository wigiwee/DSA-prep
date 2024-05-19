import java.util.*;

class Example{

//==================================================================================

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

//==================================================================================

    /*
    Q. Given an array of integers. For each element in the array, find tis next greater element in the array,
    The next greater element is the first towards right, which is greater than the current element.
    example-
    input arr={4,7,3,4,8,1,}
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

//==================================================================================

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

//==================================================================================

    //Q. generate binary numbers from 1 to n using a queue
    public String[] returnBinary(int n ){
        String[] result = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        String n1, n2;
        for (int i = 0; i < n; i++) {
            result[i] = queue.poll();
            n1 = result[i]+"0";
            n2 = result[i]+"1";
            queue.offer(n1);
            queue.offer(n2);
        }
        return result;
        

    }

//==================================================================================


//==================================================================================

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
        System.out.println("Printing the binary number from 1 to 7");
        System.out.println(Arrays.toString(example.returnBinary(7)));

    }
}
