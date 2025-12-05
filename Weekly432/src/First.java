import java.util.ArrayList;
import java.util.List;

public class First {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<grid.length; i++){
            if(i%2==0){
                for(int j=0; j<grid[0].length; j+=2){
                    res.add(grid[i][j]);
                }
            }
            else{
                int start = grid[0].length%2;
                start = grid[0].length-1-start;
                for(int j=start; j>=0; j--){
                    res.add(grid[i][j]);
                }
            }
        }
        return res;
    }
}
