class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int ast : asteroids){
            if(stack.isEmpty()){
                stack.push(ast);
            }else if(stack.peek() >0 && ast < 0){
                //colliosion
                boolean isDest = false;
                while(stack.size() >0 && stack.peek() > 0 && ast < 0){
                    if(Math.abs(ast) > Math.abs(stack.peek())){
                        stack.pop();
                    }else if(Math.abs(ast) == Math.abs(stack.peek())){
                        isDest = true;
                        stack.pop();
                        break;
                    }else{
                        isDest = true;
                        break;
                    }
                }
                if(!isDest) stack.push(ast);
            }else{
                stack.push(ast);
            }
        }
        int n = stack.size();
        int[] output = new int[n];
        for(int i = n-1; i >=0 ; i--){
            output[i] = stack.pop();
        }
        return output;
    }
}
