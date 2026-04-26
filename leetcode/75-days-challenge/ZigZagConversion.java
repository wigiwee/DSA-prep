class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0 ; i < numRows; i ++){
            rows[i] = new StringBuilder();
        }
        int i = 0;
        while(i < s.length()){
            for(int index = 0 ; index < numRows && i < s.length();index++ ){
                rows[index].append(s.charAt(i++));
            }
            for(int index = numRows-2; index > 0 && i < s.length(); index--){
                rows[index].append(s.charAt(i++));
            }
        }
        StringBuilder result =new StringBuilder();
        for(StringBuilder row: rows){
            result.append(row);
        }
        return result.toString();
    }
}
