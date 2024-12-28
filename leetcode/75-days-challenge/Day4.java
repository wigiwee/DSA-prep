/*
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new 
 * flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 */

public class Day4 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int flowerbed_length = flowerbed.length;
        if (n > flowerbed_length / 2 + 1) {
            return false;
        }
        while (n != 0) {
            if (flowerbed[i] == 0 && flowerbed[i + 1] == 0)
                n--;

            i = i + 2;

            if (i == flowerbed_length - 1) {
                if (flowerbed[i - 1] == 0) {
                    if(--n == 0){
                        return true;
                    }else 
                        return false;
                    
                }else{
                    if(n ==0){
                        return true;
                    }else
                        return false;
                }
            } else if (i == flowerbed_length) {
                if (n == 0) {
                    return true;
                }
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 0, 1 }, 2));
    }
}
