// this is too slow
// class Solution {
//     public String removeStars(String s) {
//         int n = s.length();
//         int[] output = new int[n];
//         for(int i = 0 ; i < n; i++){
//             output[i] = 1;
//             if(s.charAt(i)=='*'){
//                 output[i] = 0;
//                 for(int j = i-1; j >=0; j--){
//                     if(output[j]==1){
//                         output[j] =0;
//                         break;
//                     }
//                 }
//             }
//         }
//         StringBuilder sb = new StringBuilder();
//         for(int i = 0 ; i < n; i++){
//             if(output[i] ==1){
//             sb.append(s.charAt(i));
//             }
//         }
//         return sb.toString();
//     }
// }

// this was a bit faster
// class Solution {
//     public String removeStars(String s) {
//         int n = s.length();
//         StringBuilder output = new StringBuilder();
//         for(char ch : s.toCharArray()){
//             if (ch == '*'){
//                 output.deleteCharAt(output.length() -1 );
//             }else{
//                 output.append(ch);
//             }
//         }
//         return output.toString();
//     }
// }
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if (ch=='*'){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        StringBuilder output = new StringBuilder();
        while(!stack.isEmpty()){
            output.append(stack.pop());
        }
        return output.reverse().toString();
    }
}
