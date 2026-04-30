class Solution {
    public int romanToInt(String s) {
        
        int value[] = {1000,500,100,50,10,5,1};
        char symbol[] = {'M',  'D','C','L','X' ,'V', 'I'};
        HashMap<Character, Integer> romanNum = new HashMap();
        for(int i = 0; i < value.length; i++){
            romanNum.put(symbol[i], value[i]);
        }

        int n = s.length();
        int output = 0;
        for(int i = 0; i < n; i++){
            if((i+1 < n ) && (romanNum.get(s.charAt(i+1)) > romanNum.get(s.charAt(i)))){
                output += romanNum.get(s.charAt(i+1))-romanNum.get(s.charAt(i));
                i++;
            }else{
                output += romanNum.get(s.charAt(i));
            }
        }
        return output;
    }
}
