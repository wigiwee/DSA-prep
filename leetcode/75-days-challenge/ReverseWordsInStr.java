class Solution {
    public String reverseWords(String s) {
        String arr[] = s.split(" ");
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length -1; i >=0; i--){
            if (arr[i].length() ==0) continue;
            if(!(i==arr.length-1)){
                sb.append(" ");
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}