class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        
        while(n !=0 && i < flowerbed.length){
            boolean prev;
            boolean next;
            if(flowerbed[i] ==1) {
                i++;
                continue;
            }

            if(i==0||flowerbed[i-1]==0 ){
                prev = true;
            }else{
                prev = false;
            }
            if(i == flowerbed.length-1 || flowerbed[i+1]==0){
                next = true;
            }else{
                next = false;
            }

            if(prev && next){
                n--;
                flowerbed[i] =1;
            };

            i++;
        }
        return n==0;
    }
}