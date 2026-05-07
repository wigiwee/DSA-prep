class Solution {
    public String longestCommonPrefix(String[] strs) {
        //check for empty string here
        if(strs.length ==1) return strs[0];

        int idx = 0;
        char[] str0 = strs[0].toCharArray();
        for(int i = 0 ; i < str0.length; i++ ){
            char ch = str0[i];
            for(String str: strs){
                if(str.length() <=i ||  !(str.charAt(i)==ch)) return strs[0].substring(0,idx);
            }
            idx++;
        }
        return strs[0].substring(0,idx);
    }
}
