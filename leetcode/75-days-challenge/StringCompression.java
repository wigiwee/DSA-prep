class Solution {
    public int compress(char[] chars) {
        int ans = 0;
        int i = 0;
        while(i < chars.length ){
            char curr = chars[i];
            int count = 0;
            while(i < chars.length && chars[i] == curr){
                count++;
                i++;
            }
            chars[ans++] = curr;
            
            if(count > 1){
                for(char c : Integer.toString(count).toCharArray()){
                    chars[ans++] = c;
                }
            }
        }
        return ans;
    }
}
