import java.util.Arrays;
import java.util.Collections;

public class First {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for(int i=0; i<n; i++){
            int[] arr = new int[n-i];
            for(int x=0; x<n-i; x++){
                arr[i] = grid[i+x][x];
            }
            Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            Arrays.sort(boxedArr, Collections.reverseOrder());
            arr = Arrays.stream(boxedArr).mapToInt(Integer::intValue).toArray();

            for(int x=0; x<n-i; x++){
                grid[i+x][x] = arr[i];
            }

            if(i>0){
                int[] arr2 = new int[n-i];
                for(int x=0; x<n-i; x++){
                    arr2[i] = grid[x][i+x];
                }

                Arrays.sort(arr2);

                for(int x=0; x<n-i; x++){
                    grid[x][i+x] = arr2[i];
                }
            }
        }
        return grid;
    }
}
