class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x%10 ==0 && x!=0)) return false;
        int xRev = 0;
        while(x > xRev){
            xRev = xRev*10 +(x % 10);
            x = x/10;
        }
        return x == xRev || x == xRev/10;
    }
}
