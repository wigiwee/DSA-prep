package Arrays;

public class Main {
    public static void main(String[] args) {
        Array arr = new Array(2);
        arr.insert(4);
        arr.insert(34);
        arr.insert(56);
        arr.insert(8);
        arr.insert(43);
        System.out.println(arr);
        arr.removeAt(2);
        System.out.println(arr);
        arr.removeAt(2);
        System.out.println(arr);
        System.out.println(arr.max());
        System.out.println(arr.min());
        arr.reverse();
        System.out.println(arr);


    }
}
