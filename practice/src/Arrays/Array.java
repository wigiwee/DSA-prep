package Arrays;

public class Array {
    private int[] items;
    private int length;
    public Array(int initialSize){
        this.items = new int[initialSize];
        length = 0;
    }

    public void insert(int value){
        if(length == items.length){
            int[] temp = new int[length*2];
            for(int i = 0 ; i < this.items.length; i++){
                temp[i] = this.items[i];
            }
            this.items = temp;
        }
        this.items[length] = value;
        length++;
    }
    public int indexOf(int value){
        for (int i = 0; i < length; i++) {
            if(this.items[i] == value){
                return i;
            }
        }
        return -1;

    }
    public void removeAt(int index){
        if( index > length){
            throw new IllegalArgumentException();
        }
        for(int i = index; i<= length -1; i++){
            this.items[i] = this.items[i+1];
        }
        length--;
    }
    public int max(){
        int result = this.items[0];
        for(int i = 0; i < length; i++){
            if(this.items[i] > result){
                result= this.items[i];
            }
        }
        return result;

    }
    public int min(){
        int result = this.items[0];
        for(int i = 0; i< length; i++){
            if(this.items[i] < result){
                result = this.items[i];
            }
        }
        return result;
    }
    public void reverse (){
        int forwordPtr = 0;
        int backwordPtr = length-1;
        int temp;
        while (forwordPtr<backwordPtr){
            temp = this.items[forwordPtr];
            this.items[forwordPtr] = this.items[backwordPtr];
            this.items[backwordPtr] = temp;
            forwordPtr++;
            backwordPtr--;
        }
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[ ");
        for(int i = 0; i< this.length; i++){
            str.append(this.items[i]).append(", ");
        }
        str.append("\b").append("\b");
        str.append(" ]");
        return str.toString();

    }
}
