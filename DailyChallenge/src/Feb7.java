import java.util.HashMap;

public class Feb7 {
    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];

        HashMap<Integer, Integer> firstVals = new HashMap<>();
        HashMap<Integer, Integer> allVals = new HashMap<>();
        for(int i=0; i<queries.length; i++){

            if(firstVals.containsKey(queries[i][0])){
                int colorCount = allVals.get(firstVals.get(queries[i][0]));
                if(colorCount>1){
                    allVals.put(firstVals.get(queries[i][0]), colorCount-1);
                }
                else allVals.remove(firstVals.get(queries[i][0]));
            }
            allVals.put(queries[i][1], allVals.getOrDefault(queries[i][1], 0)+1);
            firstVals.put(queries[i][0], queries[i][1]);

            result[i] = allVals.size();
        }

        return result;
    }
}
