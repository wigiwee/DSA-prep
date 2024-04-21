public class StringUtils {
    public static void main(String[] args){

        String string = "madam" , string1 ="hello" ;
        System.out.println("is madam palindrome:  " + StringUtils.checkPalindrome(string) +"\nis hello palindrome: " + StringUtils.checkPalindrome(string1));
    }

    public static boolean checkPalindrome(String string){
        char[] charArray = string.toCharArray();
        int start = 0 , end = charArray.length -1;
        while( end>start){
            if(charArray[start]!=charArray[end] ){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
