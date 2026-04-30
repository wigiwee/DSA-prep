class Solution {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length()-1;
        HashSet<Character> vowelSet = new HashSet(Arrays.asList('a','e','i','o','u','A','E','I','O', 'U'));
        char[] arr = s.toCharArray();
        while(left < right){
            while(left< right && !vowelSet.contains(arr[left])) left++;
            while(left < right && !vowelSet.contains(arr[right])) right--;

            
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return new String(arr);
    }
}