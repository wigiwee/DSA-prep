/* 
There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of 
candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.

Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, 
they will have the greatest number of candies among all the kids, or false otherwise.

Note that multiple kids can have the greatest number of candies.
 

Example 1:

Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true] 
*/

import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> kidsWithCandies = new ArrayList<>();
        
        int maxCandies = 0;
        for(int i = 0 ; i < candies.length; i++){
            if(candies[i] > maxCandies)
                maxCandies = candies[i];
        }
        for (int candy : candies) {
            if((candy + extraCandies) >= maxCandies){
                kidsWithCandies.add(true);
            }else{
                kidsWithCandies.add(false);
            }
        }
        return kidsWithCandies;
    }
    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2,5,6,9,8,4}, 3).toString());
        
    }

}