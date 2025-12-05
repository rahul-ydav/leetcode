public class First {
    public long calculateScore(String[] instructions, int[] values) {

        int i = 0;

        int n = values.length;

        long score = 0;
        int[] visited = new int[n];

        while(i>=0 || i<n){
            if(visited[i]==1)  break;
            visited[i] = 1;
            if(instructions[i].equals("add")){
                score += (long)values[i];
                i++;
            }
            else {// if(instructions[i]=="jump"){
                i = i+values[i];
            }

            System.out.println("i: "+i);
            System.out.println("score: "+score);
        }

        return score;

    }
}