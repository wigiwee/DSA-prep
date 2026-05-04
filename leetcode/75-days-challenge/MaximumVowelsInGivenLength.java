class Solution {
    public int maxVowels(String s, int k) {

        int vCount = 0;
        char[] sArr = s.toCharArray();
        for(int i = 0; i < k; i++){
            if(isVowel(sArr[i])) vCount++;
        }
        int maxCount =vCount;
        for(int i = 0 ; i < sArr.length-k;i++){
            if(maxCount==k) return maxCount;

            if(isVowel(sArr[i+k])) vCount++;

            if(isVowel(sArr[i])) vCount--;

            if(maxCount < vCount) maxCount = vCount;
        }
        return maxCount;
    }

    public boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' ||ch=='u';
    }
}
