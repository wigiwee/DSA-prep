class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;
        HashMap<List<Integer>, Integer> map = new HashMap<>();

        // storing rows in map
        for(int i = 0 ; i < n; i++ ){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <n ; j++ ){
                row.add(grid[i][j]);
            }
            map.put(row, map.getOrDefault(row, 0) +1);
            
        }
        // matching rows with columns
        for(int j = 0; j < n; j++){
            List<Integer> column = new ArrayList<>();
            for(int i =0 ; i < n; i++){
                column.add(grid[i][j]);
            }
            count += map.getOrDefault(column, 0);
        }
        return count;
    }
}
